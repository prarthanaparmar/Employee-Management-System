package com.empmanagement.controller;

import com.empmanagement.domain.TimeSheetDetail;
import com.empmanagement.service.ITimeSheetOverTimeLimit;
import com.empmanagement.service.ITimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This controller handles all the request related to time sheet functionality of our application
 *               This controller will handle all the request mappings related to time sheet activities.
 * */
@Controller
public class TimeSheetController {

    @Autowired
    ITimeSheetService timeSheetService;
    @Autowired
    ITimeSheetOverTimeLimit timeSheetOverTimeLimit;

    @GetMapping("/ems/timeSheet")
    public String timeSheetInfo(HttpSession session,Model model) {
        Long employeeId = (Long) session.getAttribute("EMP_ID");
        model.addAttribute("timesheet", timeSheetService.getTimeSheetDetails(employeeId.toString()));
        model.addAttribute("totalhours", timeSheetService.getHoursWorked(employeeId.toString()));
        model.addAttribute("totalhours_week", timeSheetService.getCurrentWeeklyHoursDetail(employeeId.toString()));
        model.addAttribute("totalhours_month", timeSheetService.getCurrentMonthlyHoursDetail(employeeId.toString()));
        if(timeSheetOverTimeLimit.getOvertimeLimit(employeeId.toString())){
            model.addAttribute("limit","Your weekly time exceeds 40 hours. Please report to your manager for this.");
        }
        model.addAttribute("future_timesheet", timeSheetService.getFutureTimeSheetDetails(employeeId.toString()));
        return "timesheet";
    }

}
