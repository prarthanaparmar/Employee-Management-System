package com.empmanagement.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empmanagement.dao.InvestmentDeclarationDAO;
import com.empmanagement.domain.Earnings;
import com.empmanagement.domain.Salary;
import com.empmanagement.service.SalaryService;

@Controller
public class FinanceController {
	@Autowired
	private InvestmentDeclarationDAO investmentDAO;
	
	@Autowired
	private SalaryService salaryService;

	@GetMapping("/ems/investmentdeclaration")
	public String investmentDeclarationForm(HttpSession session, Model model) {
		Long employeeId = (Long) session.getAttribute("EMP_ID");
		
		if(employeeId == null) {
			return "redirect:/ems/login";
		}

		System.out.println(employeeId);

		Long empId = employeeId;
		model.addAttribute("emp_id", empId);
		return "investment-declaration";
	}

	@PostMapping("/ems/investmentdeclaration/submit")
	public String submitInvestmentDeclaration(@RequestParam(name = "empId", required = true) Long empId,
			@RequestParam(name = "homeLoanInterest", required = true) Long homeLoanInterest,
			@RequestParam(name = "lifeInsuranceInvestment", required = true) Long lifeInsuranceInvestment,
			@RequestParam(name = "mutualFundInvestment", required = true) Long mutualFundInvestment,
			RedirectAttributes redirectAttribute) {

		String dbSaveStatus = investmentDAO.saveInvestmentDeclaration(empId, homeLoanInterest, lifeInsuranceInvestment,
				mutualFundInvestment);

		if (dbSaveStatus.equals("success")) {
			redirectAttribute.addFlashAttribute("success",
					"Your investment declaration has been submitted successfully. ");
		} else {
			redirectAttribute.addFlashAttribute("error",
					"Some error was encountered while saving your information. Please try again later.");
		}
		return "redirect:/ems/investmentdeclaration";

	}
	
	@GetMapping("/ems/salarystructure")
	public String getSalaryStructure(HttpSession session, Model model) {
		Long employeeId = (Long) session.getAttribute("EMP_ID");
		if(employeeId == null) {
			return "redirect:/ems/login";
		}
		Long empId = employeeId;
		
		Salary salary = salaryService.getSalaryForEmployee(empId);

		model.addAttribute("salary", salary );
		
		model.addAttribute("emp_id", empId);
		return "salary-structure";
	}

}
