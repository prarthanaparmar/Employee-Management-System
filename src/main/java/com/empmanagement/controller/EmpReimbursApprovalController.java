package com.empmanagement.controller;

import com.empmanagement.service.IReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
/**
 * This classes takes care of Employee Reimbursement Approval related operations
 *
 * @author Prarthanaben Parmar
 *
 */

public class EmpReimbursApprovalController {

    @Autowired
    private IReimbursementService reimburseservice;

    @GetMapping("/ems/reimbursement-approval")
    public String reimbursementapproval(HttpSession session, Model model) {
        Long employeeId = (Long) session.getAttribute("EMP_ID");

        if (employeeId == null) {
            return "redirect:/ems/login";
        }
        return "reimbursement-approval";
    }

    @PostMapping("/ems/reimbursement-approval/submit")
    public String reimburseApproval(RedirectAttributes redirectAttribute,
                                    Model model) {
        String status = reimburseservice.getAllRequests();

        if (status == "success") {
            redirectAttribute.addFlashAttribute("success", "Reimbursement approval succeeded");
            return "redirect:/ems/reimbursement-approval";
        } else {
            redirectAttribute.addFlashAttribute("error", "Please try again");
            return "redirect:/ems/reimbursement-approval";
        }
    }
}
