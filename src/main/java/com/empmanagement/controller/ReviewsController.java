package com.empmanagement.controller;

import com.empmanagement.domain.EmployeeReviewForm;
import com.empmanagement.domain.ManagerReviewForm;
import com.empmanagement.service.PerformanceManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class ReviewsController {
    @Autowired
    PerformanceManagementService performanceManagementService;

    @GetMapping("/ems/managerReviews")
    public String getManagerData(HttpSession session, Model model){
        Long employeeId = (Long) session.getAttribute("EMP_ID");
        model.addAttribute("reviews",performanceManagementService.getReviews(employeeId.toString()));
        model.addAttribute("managers",performanceManagementService.getManagers(employeeId.toString()));
        return "manager-reviews";
    }

    @GetMapping("/ems/peerReviews")
    public String getPeerData(HttpSession session, Model model){
        Long employeeId = (Long) session.getAttribute("EMP_ID");
        model.addAttribute("reviews",performanceManagementService.getReviews(employeeId.toString()));
        model.addAttribute("peers",performanceManagementService.getPeers(employeeId.toString()));
        return "peer-reviews";
    }

    @PostMapping("/ems/managerReviews")
    public String postManagerReviewData(@ModelAttribute("managerReviewForm") ManagerReviewForm managerReviewForm,
                                 RedirectAttributes redirectAttribute,
                                 HttpSession session){
        Long employeeId = (Long) session.getAttribute("EMP_ID");
        if(!performanceManagementService.checkManagerInput(managerReviewForm)){
            redirectAttribute.addFlashAttribute("managerError", "Please select a manager");
        }
        else if(!performanceManagementService.checkManagerGeneralInput(managerReviewForm)){
            redirectAttribute.addFlashAttribute("IncorrectInputError", "Your input is invalid. Please enter again");
        }
        else{
            String dbSaveStatus=performanceManagementService.saveManagerReview(employeeId.toString(),managerReviewForm);
            if (dbSaveStatus.equals("success")) {
                redirectAttribute.addFlashAttribute("success",
                        "Your review has been submitted successfully. ");
            } else {
                redirectAttribute.addFlashAttribute("error",
                        "Some error was encountered while saving your information OR you are reviewing the employee again. Please try again later.");
            }
        }
        return "redirect:/ems/managerReviews";

    }

    @PostMapping("/ems/peerReviews")
    public String postPeerReviewData(@ModelAttribute("employeeReviewForm") EmployeeReviewForm employeeReviewForm,
                                        RedirectAttributes redirectAttribute,
                                        HttpSession session){
        Long employeeId = (Long) session.getAttribute("EMP_ID");
        if(!performanceManagementService.checkPeerInput(employeeReviewForm)){
            redirectAttribute.addFlashAttribute("managerError", "Please select a manager");
        }
        else if(!performanceManagementService.checkPeerGeneralInput(employeeReviewForm)){
            redirectAttribute.addFlashAttribute("IncorrectInputError", "Your input is invalid. Please enter again");
        }
        else{
            String dbSaveStatus=performanceManagementService.savePeerReview(employeeId.toString(),employeeReviewForm);
            if (dbSaveStatus.equals("success")) {
                redirectAttribute.addFlashAttribute("success",
                        "Your review has been submitted successfully. ");
            } else {
                redirectAttribute.addFlashAttribute("error",
                        "Some error was encountered while saving your information OR you are reviewing the employee again. Please try again later.");
            }
        }
        return "redirect:/ems/peerReviews";

    }
}
