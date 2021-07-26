package com.empmanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.empmanagement.domain.CheckInOutDetails;
import com.empmanagement.service.ICheckInOutService;
import com.empmanagement.service.ICheckInOutServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;


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

        return "employee-homescreen";
    }

    @GetMapping("/ems/home-screen")
    public String Checkout(HttpSession session,Model model) {
        Long employeeId = (Long) session.getAttribute("EMP_ID");
        System.out.println("For employee id :"+employeeId);
        checkInOutService.addCheckOut(employeeId);

        return "home-screen";
    }

    @PostMapping("/ems/employeehomescreen/edit")
    public String EditDetails(HttpSession session,Model model)
    {
        return "edit-employee-details";
    }

    @PostMapping("/ems/employeehome-screen")
    public String Detailscreen(HttpSession session,Model model)
    {
        return "employee-screen";
    }


    public String getData(HttpSession session, Model model) {
        Long employeeId = (Long) session.getAttribute("EMP_ID");
        return "Check-In/out";
    }
}
