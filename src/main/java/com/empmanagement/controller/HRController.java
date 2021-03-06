package com.empmanagement.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.empmanagement.dao.EmpregisterDAO;
import com.empmanagement.dao.EmpregisterDAOImpl;
import com.empmanagement.service.EmpReg;
import com.empmanagement.service.EmpRegImpl;

@Controller
public class HRController {

	@Autowired
	private EmpregisterDAO empRegDao = new EmpregisterDAOImpl();
	private EmpReg empreg = new EmpRegImpl();
	
	@GetMapping("ems/hr-homescreen")
	public String hrhomescreen() {
		return "hr-homescreen";
	}

	
	@GetMapping("/ems/employee-registration")
	public String empRegistrationForm() {
		return "employee-registration";
	}

	@PostMapping("/ems/employee-registration/submit")
	public String regEmpDetails(@RequestParam(name = "firstname" ,required = true)String firstname,@RequestParam(name="lastname", required = true)String lastname,@RequestParam(name = "email",required = true)String email,	
					@RequestParam(name="doj",required=true) Date doj,@RequestParam(name="dob",required=true) Date dob,@RequestParam(name="role", required=true) String role,
					@RequestParam(name="grade" , required=true) String grade,@RequestParam(name="deptname", required =true)String deptname,
					@RequestParam(name="team", required=true)String team,
					RedirectAttributes redirectAttribute,
					Model model){	
		
		String companyEmail = empreg.generateEmail(firstname, lastname);
		String registerStatus = empRegDao.registerEmp(empreg.getFullName(firstname, lastname),companyEmail,doj,dob,role,grade, empRegDao.getDeptId(deptname),team);
		int empId = empRegDao.getEmpId(empreg.getFullName(firstname, lastname), dob);
		String logindetails = empRegDao.loginDetails(empreg.getEmpUserName(firstname, lastname),empreg.getPassword(), empId);
		
		if(registerStatus.equals("success") && logindetails.equals("success")) {
			redirectAttribute.addFlashAttribute("Done", "The details of new wmployee have been saved successfully");
		} else {
	    redirectAttribute.addFlashAttribute("error", "The details were not saved properly. Please try again");
		}
		return "redirect:/ems/employee-registration";
	}

}