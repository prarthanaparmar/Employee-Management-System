package com.empmanagement.controller;

import com.empmanagement.domain.TimeSheetDetail;
import com.empmanagement.service.TimeSheetService;
import com.empmanagement.service.TimeSheetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;


@Controller
public class TimeSheetController {

    @Autowired
    TimeSheetService timeSheetService;

    @GetMapping("/ems/timeSheet")
    public String timeSheetInfo(HttpSession session,Model model) {
        Long employeeId = (Long) session.getAttribute("EMP_ID");
        System.out.println("For employee id :"+employeeId);

        model.addAttribute("timesheet", timeSheetService.getTimeSheetDetails(employeeId.toString()));
        model.addAttribute("totalhours", timeSheetService.getHoursWorked(employeeId.toString()));
        model.addAttribute("totalhours_week", timeSheetService.getCurrentWeekDetail(employeeId.toString()));
        model.addAttribute("totalhours_month", timeSheetService.getCurrentMonthDetail(employeeId.toString()));
        if(timeSheetService.getLimit(employeeId.toString())){
            model.addAttribute("limit","Your weekly time exceeds 40 hours. Please report to your manager for this.");
        }

        model.addAttribute("future_timesheet", timeSheetService.getFutureTimeSheetDetails(employeeId.toString()));
        return "timesheet";
    }


    @PostMapping("/ems/timeSheet")
    public String filterResult(HttpSession session,Model model,@ModelAttribute TimeSheetDetail timeSheet) {
        return "redirect:/ems/timesheet";
    }

}
