package com.empmanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.empmanagement.domain.CheckInOutDetails;
import com.empmanagement.service.ICheckInOutService;
import com.empmanagement.service.ICheckInOutServiceImpl;


import javax.servlet.http.HttpSession;


@Controller
public class CheckInCheckOutController {

    @Autowired
    ICheckInOutService checkInOutService;

    @GetMapping("/ems/employeehomescreen")
    public String CheckIn(HttpSession session,Model model) {
        Long employeeId = (Long) session.getAttribute("EMP_ID");
        System.out.println("For employee id :"+employeeId);

        checkInOutService.addCheckIn(employeeId);

        //model.addAttribute("CheckIn", checkInOutService.addCheckIn(employeeId));
        //model.addAttribute("CheckOut", checkInOutService.addCheckOut(employeeId));
        //model.addAttribute("totalhours", timeSheetService.getHoursWorked(employeeId.toString()));
        //model.addAttribute("totalhours_week", timeSheetService.getCurrentWeekDetail(employeeId.toString()));


        return "employee-homescreen";
    }

    @GetMapping("/ems/home-screen")
    public String Checkout(HttpSession session,Model model) {
        Long employeeId = (Long) session.getAttribute("EMP_ID");
        System.out.println("For employee id :"+employeeId);
        checkInOutService.addCheckOut(employeeId);

        return "home-screen";
    }

    public String getData(HttpSession session, Model model) {
        Long employeeId = (Long) session.getAttribute("EMP_ID");
        return "Check-In/out";
    }
}
