package com.empmanagement.controller;

import com.empmanagement.service.IOffBoardingService;
import com.empmanagement.service.ISendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
/**
 * This classes takes care of Employee Offboarding related operations
 *
 * @author Prarthanaben Parmar
 *
 */

public class EmpOffBoardingController {

    @Autowired
    private IOffBoardingService offBoardService;

    @Autowired
    private ISendEmailService sendEmail;

    private double fullAndFinal;
    private String message;
    private String subject;
    private String personalEmail;

    @GetMapping("ems/emp-offboarding")
    public String offBoarding(HttpSession session, Model model) {
        Long employeeId = (Long) session.getAttribute("EMP_ID");

        if (employeeId == null) {
            return "redirect:/ems/login";
        }
        return "emp-offboarding";
    }
    @PostMapping("/ems/emp-offboarding/submit")
    public String offBoardingSubmit(@RequestParam(name = "employeeId", required = true) Long employeeId,
                                    RedirectAttributes redirectAttribute,
                                    Model model) {
        fullAndFinal = offBoardService.calculateFNF(employeeId);
        message = "Hello, your FNF is " + fullAndFinal;
        subject = "Wish you good luck!";
        personalEmail = offBoardService.getEMail(employeeId);
        sendEmail.sendMail(subject, message, personalEmail);
        offBoardService.disableUser(employeeId);
        offBoardService.offBoardEmp(employeeId);
        return "redirect:/ems/emp-offboarding";
    }
}
