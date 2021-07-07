package com.empmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empmanagement.dao.InvestmentDeclarationDAO;
import com.empmanagement.service.LoginService;

@Controller
public class FinanceController {
	@Autowired
	private InvestmentDeclarationDAO investmentDAO;

	@GetMapping("/ems/investmentdeclaration")
	public String investmentDeclarationForm() {
		return "investment-declaration";
	}
	
	@PostMapping("/ems/investmentdeclaration/submit")
	public String submitInvestmentDeclaration(@RequestParam(name = "empId", required = true) Long empId, @RequestParam(name = "homeLoanInterest", required = true) Long homeLoanInterest,
			@RequestParam(name = "lifeInsuranceInvestment", required = true) Long lifeInsuranceInvestment, 
			@RequestParam(name = "mutualFundInvestment", required = true) Long mutualFundInvestment, 
			RedirectAttributes redirectAttribute,
			Model model) {
		
		String dbSaveStatus = investmentDAO.saveInvestmentDeclaration(empId, homeLoanInterest, lifeInsuranceInvestment, mutualFundInvestment);
		
		if(dbSaveStatus.equals("success")) {
		redirectAttribute.addFlashAttribute("success", "Your investment declaration has been submitted successfully. ");
		} else {
	    redirectAttribute.addFlashAttribute("error", "Some error was encountered while saving your information. Please try again later.");
		}
		return "redirect:/ems/investmentdeclaration";

	}


//	@PostMapping("/ems/home")
//	public String loginSubmit(@RequestParam(name = "userName", required = true) String userName,
//			@RequestParam(name = "password", required = true) String password, 
//			RedirectAttributes redirectAttribute,
//			Model model) {
//
//		boolean isPasswordValid = loginService.validatePassword(userName, password);
//
//		if(isPasswordValid) {
//
//			return "home-screen";
//		} else {
//			redirectAttribute.addFlashAttribute("error", "Password provided by you is incorrect, Please try again.");
//			return "redirect:/ems/login";
//		}
//
//		
//	}
}
