package com.empmanagement.controller;

import com.empmanagement.service.PerformanceManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class PerformanceManagementController {
    @Autowired
    PerformanceManagementService performanceManagementService;

    @GetMapping("/ems/performanceManagement")
    public String getData(HttpSession session, Model model){
        Long employeeId = (Long) session.getAttribute("EMP_ID");
        Map<String,Double> scores=performanceManagementService.getScores(employeeId.toString());

        for (Map.Entry<String, Double> entry : scores.entrySet()) {
           model.addAttribute(entry.getKey(),entry.getValue());
        }

        if(performanceManagementService.checkPendingReviews(employeeId.toString())){
            model.addAttribute("pendingReview","You have manager review pending. Please fill the review.");
        }

        return "performance-management";
    }
}
