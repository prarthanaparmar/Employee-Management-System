package com.empmanagement.controller;

import com.empmanagement.domain.EmployeetrainingDetails;

import com.empmanagement.service.IEmployeetrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class EmployeetrainingController {

    @Autowired
    IEmployeetrainingService employeetrainingService;

    @GetMapping("/ems/training")
    public String trainingdetails(HttpSession session, Model model) {
        Long employeeId = (Long) session.getAttribute("EMP_ID");
        System.out.println("For employee id :" + employeeId);


        return "employee-training";

    }

    @PostMapping("/ems/training/search")
    public String search(@RequestParam(name = "searchkeyword") String keyword, Model model)
    {



        model.addAttribute("keyword",keyword);

        return "training-search-result";
    }



    @PostMapping("/ems/training")
    public String filterResult(HttpSession session, Model model, @ModelAttribute EmployeetrainingDetails training) {
        return "redirect:/ems/employee-training";
    }
}