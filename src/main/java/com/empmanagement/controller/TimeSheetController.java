package com.empmanagement.controller;

import com.empmanagement.domain.EmployeeDetail;
import com.empmanagement.domain.TimeSheetDetail;
import com.empmanagement.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class TimeSheetController {
    @Autowired
    TimeSheetService timeSheetService;
    @Autowired
    EmployeeDetail employeeDetail;

    @GetMapping("/ems/timeSheet")
    public String timeSheetInfo(Model model) {
        List<TimeSheetDetail> tsd=timeSheetService.getTimeSheetDetails(employeeDetail.getEmpId());
        List<Long> hoursWorked=new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        for(TimeSheetDetail t:tsd){
            try {
                hoursWorked.add(getTimeDifference(format.parse(t.getStart_time()),format.parse(t.getEnd_time())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        int count=0;
        long totalHours=0;
        for(Long hours:hoursWorked){
            System.out.println(hours);
            System.out.println("Time diff :"+ (hours / (60 * 60 * 1000) % 24) +":"+(hours / (60 * 1000) % 60));
            System.out.println(hoursWorked.indexOf(hours));
            totalHours+=hours;
            tsd.get(count).setHours_worked((hours / (60 * 60 * 1000) % 24) +":"+(hours / (60 * 1000) % 60));
            count++;
            System.out.println("The set value is " + tsd.get(hoursWorked.indexOf(hours)).getHours_worked());
        }
        model.addAttribute("timesheet",tsd);
        System.out.println("Total hours is "+getHours(totalHours));
        model.addAttribute("totalhours",getHours(totalHours));
        return "timesheet";
    }
    private String getHours(long milliseconds){
        final long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds);

        final long minute = TimeUnit.MILLISECONDS.toMinutes(milliseconds);

        final long hours = TimeUnit.MILLISECONDS.toHours(milliseconds);

        final long days = TimeUnit.MILLISECONDS.toDays(milliseconds);

        if(milliseconds < 1000){
            return (days +"d:" +hours+"h:" +minute+"m:" +seconds +"s:" +milliseconds +"ms");
        }
        else{
            return (days +"d:" +hours % 24 +"h:" +minute % 60 +"m:" +seconds % 60 +"s");
        }

    }
    private long getTimeDifference(Date start, Date end){
        System.out.println("Time diff would be " );
        System.out.println((end.getTime()-start.getTime())/ (60 * 60 * 1000) % 24);
        return end.getTime()-start.getTime();
    }
}
