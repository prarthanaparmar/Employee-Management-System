package com.empmanagement.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.empmanagement.domain.Salary;
import com.empmanagement.service.ISalaryService;
import com.empmanagement.util.DateUtils;

/**
 * This class is the controller class for finance related operations in the
 * application Handles the request mappings for Investment Declaration and
 * salary calculation
 * 
 * @author Priti Sri Pandey
 * 
 */
@Controller
public class SalaryController {

	@Autowired
	private ISalaryService salaryService;

	@GetMapping("/ems/salarystructure")
	public String getSalaryStructure(HttpSession session, Model model) {
		Long employeeId = (Long) session.getAttribute("EMP_ID");
		if (employeeId == null) {
			return "redirect:/ems/login";
		}
		Long empId = employeeId;
		Date lastSalDate = DateUtils.getTodaysDate();
		Salary salary = salaryService.getSalaryForEmployee(empId);

		model.addAttribute("salary", salary);
		model.addAttribute("salaryDate", lastSalDate);

		model.addAttribute("emp_id", empId);
		return "salary-structure";
	}

}
