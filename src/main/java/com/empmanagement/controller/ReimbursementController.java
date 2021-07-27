package com.empmanagement.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empmanagement.service.IReimbursementService;

/**
 * This class is the controller class for finance related operations in the
 * application Handles the request mappings for Investment Declaration and
 * salary calculation
 * 
 * @author Priti Sri Pandey
 * 
 */
@Controller
public class ReimbursementController {

	@Autowired
	private IReimbursementService reimbursementService;

	@GetMapping("/ems/applyreimbursement")
	public String applyReimbursement(HttpSession session) {
		Long employeeId = (Long) session.getAttribute("EMP_ID");
		if (employeeId == null) {
			return "redirect:/ems/login";
		}
		return "apply-reimbursement";
	}

	@PostMapping("/ems/applyreimbursement/submit")
	public String submitReimbursement(HttpSession session,
			@RequestParam(name = "reimbursementAmount", required = true, defaultValue = "0") Long claimedReimbursementAmt,
			RedirectAttributes redirectAttribute) {
		Long employeeId = (Long) session.getAttribute("EMP_ID");
		String dbSaveStatus = reimbursementService.saveAppliedReimbursement(employeeId, claimedReimbursementAmt);

		if (employeeId == null) {
			return "redirect:/ems/login";
		}
		
		if (dbSaveStatus.equals("success")) {
			redirectAttribute.addFlashAttribute("success",
					"Your Reimbursement Claim has been submitted for approval.");
		} else {
			redirectAttribute.addFlashAttribute("error",
					"Some error was encountered while saving your request. Please try again later.");
		}

		return "redirect:/ems/applyreimbursement";
	}

}
