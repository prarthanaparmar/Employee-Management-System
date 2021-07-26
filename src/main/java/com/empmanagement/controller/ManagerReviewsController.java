package com.empmanagement.controller;

import com.empmanagement.domain.EmployeeReviewForm;
import com.empmanagement.service.ICheckReviews;
import com.empmanagement.service.IManangerReviewsService;
import com.empmanagement.service.IReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class ManagerReviewsController {
    @Autowired
    IManangerReviewsService manangerReviews;
    @Autowired
    IReviewsService reviews;
    @Autowired
    ICheckReviews checkReviews;

    @GetMapping("/ems/managerReviews")
    public String getManagerData(HttpSession session, Model model){
        Long employeeId = (Long) session.getAttribute("EMP_ID");
        model.addAttribute("reviews",reviews.getReviews(employeeId.toString()));
        model.addAttribute("managers",manangerReviews.getManagers(employeeId.toString()));
        return "manager-reviews";
    }

    @PostMapping("/ems/managerReviews")
    public String postManagerReviewData(@ModelAttribute("managerReviewForm") EmployeeReviewForm managerReviewForm,
                                        RedirectAttributes redirectAttribute,
                                        HttpSession session){
        Long employeeId = (Long) session.getAttribute("EMP_ID");
        if(!checkReviews.checkInput(managerReviewForm)){
            redirectAttribute.addFlashAttribute("managerError", "Please select a manager");
        }
        else if(!checkReviews.checkGeneralInput(managerReviewForm)){
            redirectAttribute.addFlashAttribute("IncorrectInputError", "Your input is invalid. Please enter again");
        }
        else{
            String dbSaveStatus=checkReviews.saveReview(employeeId.toString(),managerReviewForm);
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
}
