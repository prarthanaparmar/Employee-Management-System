package com.empmanagement.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empmanagement.domain.InvestmentDeclaration;
import com.empmanagement.service.IInvestmentDeclarationService;

/**
 * This class is the controller class for finance related operations in the
 * application Handles the request mappings for Investment Declaration and
 * salary calculation
 * 
 * @author Priti Sri Pandey
 * 
 */
@Controller
public class InvestmentController {
	@Autowired
	private IInvestmentDeclarationService investmentService;

	@GetMapping("/ems/investmentdeclaration")
	public String investmentDeclarationForm(HttpSession session, Model model) {
		Long employeeId = (Long) session.getAttribute("EMP_ID");

		if (employeeId == null) {
			return "redirect:/ems/login";
		}

		Long empId = employeeId;
		InvestmentDeclaration investment = investmentService.getInvestmentDeclaration(empId);
		model.addAttribute("investment", investment);
		return "investment-declaration";
	}

	@GetMapping("/ems/edit-investmentdeclaration")
	public String editInvestmentDeclarationForm(HttpSession session, Model model) {
		Long employeeId = (Long) session.getAttribute("EMP_ID");

		if (employeeId == null) {
			return "redirect:/ems/login";
		}

		Long empId = employeeId;
		model.addAttribute("emp_id", empId);
		return "edit-investment-declaration";
	}

	@PostMapping("/ems/investmentdeclaration/submit")
	public String submitInvestmentDeclaration(
			@RequestParam(name = "homeLoanInterest", required = true, defaultValue = "0") Long homeLoanInterest,
			@RequestParam(name = "lifeInsuranceInvestment", required = true, defaultValue = "0") Long lifeInsuranceInvestment,
			@RequestParam(name = "mutualFundInvestment", required = true, defaultValue = "0") Long mutualFundInvestment,
			RedirectAttributes redirectAttribute, HttpSession session) {

		Long employeeId = (Long) session.getAttribute("EMP_ID");
		String dbSaveStatus = investmentService.saveInvestmentDeclaration(employeeId, homeLoanInterest,
				lifeInsuranceInvestment, mutualFundInvestment);

		if (dbSaveStatus.equals("success")) {
			redirectAttribute.addFlashAttribute("success",
					"Your investment declaration has been submitted successfully. ");
		} else {
			redirectAttribute.addFlashAttribute("error",
					"Some error was encountered while saving your information. Please try again later.");
		}
		return "redirect:/ems/investmentdeclaration";

	}

}
