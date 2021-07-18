package com.empmanagement.controller;

import com.empmanagement.domain.EmployeeDetail;
import com.empmanagement.domain.TimeSheetDetail;
import com.empmanagement.service.TimeSheetService;
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

        model.addAttribute("timesheet",timeSheetService.getTimeSheetDetails(employeeId.toString()));
        model.addAttribute("totalhours",timeSheetService.getHoursWorked(employeeId.toString()));
        model.addAttribute("totalhours_week",timeSheetService.getCurrentWeekDetail(employeeId.toString()));
        model.addAttribute("totalhours_month",timeSheetService.getCurrentMonthDetail(employeeId.toString()));

        return "timesheet";
    }


    @PostMapping("/ems/timeSheet")
    public String filterResult(HttpSession session,Model model,@ModelAttribute TimeSheetDetail timeSheet) {
        return "redirect:/ems/timesheet";
    }

}
