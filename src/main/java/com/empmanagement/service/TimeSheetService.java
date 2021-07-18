package com.empmanagement.service;

import com.empmanagement.dao.TimeSheetDAO;
import com.empmanagement.domain.EmployeeDetail;
import com.empmanagement.domain.TimeSheetDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.LoginDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
public class TimeSheetService {

    @Autowired
    private TimeSheetDAO timeSheetDAO;

    public List<TimeSheetDetail> getTimeSheetDetails(String userId){
        System.out.println("At service level "+userId);
        List<TimeSheetDetail> tsd=timeSheetDAO.getTimeSheetDetail(userId);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        if(tsd.size()!=0) {
            for (TimeSheetDetail t : tsd) {
                try {
                    t.setHours_worked(getHours(getTimeDifference(format.parse(t.getStart_time()), format.parse(t.getEnd_time()))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return tsd;
        }
        else{
            return null;
        }
    }

    public String getHoursWorked(String userId){
        List<TimeSheetDetail> tsd=timeSheetDAO.getTimeSheetDetail(userId);
        List<Long> hoursWorked=new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        if(tsd.size()!=0) {
            for (TimeSheetDetail t : tsd) {
                try {
                    hoursWorked.add(getTimeDifference(format.parse(t.getStart_time()), format.parse(t.getEnd_time())));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            long totalHours = getTotalHours(tsd, hoursWorked);
            return getHours(totalHours);
        }
        else{
            return null;
        }
    }

    public String getCurrentMonthDetail(String userId){
        System.out.println("At service level "+userId);
        List<TimeSheetDetail> tsd_month=timeSheetDAO.getCurrentMonthDetail(userId);
        List<Long> hoursWorked_month=new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        if(tsd_month.size()!=0) {
            for (TimeSheetDetail t_month : tsd_month) {
                try {
                    hoursWorked_month.add(getTimeDifference(format.parse(t_month.getStart_time()), format.parse(t_month.getEnd_time())));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            long totalHours_month=getTotalHours(tsd_month,hoursWorked_month);
            return getHours(totalHours_month);
        }
        else{
            return null;
        }

       // return timeSheetDAO.getTimeSheetDetail(userId).size() != 0 ? timeSheetDAO.getCurrentMonthDetail(userId) : null;
    }

    public String getCurrentWeekDetail(String userId){

        System.out.println("At service level "+userId);
        List<TimeSheetDetail> tsd_week=timeSheetDAO.getCurrentWeekDetail(userId);
        List<Long> hoursWorked_week=new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        if(tsd_week.size() !=0){
            for(TimeSheetDetail t_week:tsd_week){
                try {
                    hoursWorked_week.add(getTimeDifference(format.parse(t_week.getStart_time()),format.parse(t_week.getEnd_time())));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            long totalHours_week=getTotalHours(tsd_week,hoursWorked_week);
            return getHours(totalHours_week);
        }
        else{
            return null;
        }
    }

    private long getTotalHours(List<TimeSheetDetail> tsd,List<Long> hoursWorked){
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
        return totalHours;
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

