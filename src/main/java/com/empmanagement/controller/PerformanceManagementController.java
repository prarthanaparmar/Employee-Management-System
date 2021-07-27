package com.empmanagement.controller;

import com.empmanagement.service.IPerformanceManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This controller handles all the request related to performance management functionality of our application
 *               This controller will handle all the request mappings related to performance management activities.
 * */
@Controller
public class PerformanceManagementController {
    @Autowired
    IPerformanceManagementService performanceManagementService;

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
