package com.empmanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empmanagement.service.LoginService;

@Controller
public class ManagerController {

    @Autowired
    private MangerDAO ManagerDAO;

    @GetMapping("/ems/Manager-profile")
    public String loginForm(HttpSession session, Model model) {

            Long employeeId = (Long) session.getAttribute("EMP_ID");

            if(employeeId == null) {
                return "redirect:/ems/login";
            }

            System.out.println(employeeId);

            Long empId = employeeId;
            //ManagerDAO.getManagerEmpIDFromDatabase("Finance");
            model.addAttribute("emp_id", empId);

        return "Manager-profile";
    }




    @GetMapping("/ems/home")
    public String homePage() {
        return "home-screen";
    }
}
