package com.empmanagement.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.security.auth.Subject;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.empmanagement.dao.IEmpregisterDAO;
import com.empmanagement.dao.IOffBoardingDao;
import com.empmanagement.dao.EmpregisterDAOImpl;
import com.empmanagement.service.IEmpRegService;
import com.empmanagement.service.IEncodePassService;
import com.empmanagement.service.IOffBoardingService;
import com.empmanagement.service.EmpRegServiceImpl;
import com.empmanagement.service.IReimbursementService;
import com.empmanagement.service.ISendEmailService;
import com.empmanagement.service.OffBoardingServiceImpl;
import com.empmanagement.service.ReimbursementServiceImpl;
import com.empmanagement.service.SendEmailService;
import com.sun.mail.handlers.message_rfc822;

import ch.qos.logback.core.joran.conditional.IfAction;

@Controller
public class HRController {
	
	@Autowired
	private IEmpRegService empreg;
	
	@Autowired
	private IReimbursementService reimburseservice;
	
	@Autowired
	private IOffBoardingService offBoardService;
	
	@Autowired
	private ISendEmailService sendEmail;
	
	@Autowired
	private IEncodePassService encodeService;
	
	
	private String companyEmail;
	private String registerStatus;
	private Long empId;
	private double fullAndFinal;
	private String password;
	private String encodePass;
	private String message;
	private String subject;
	private String personalEmail;
	private int deptId;
	static final String STATUS = "active";
	private String empUserName;
	
	@GetMapping("ems/hr-homescreen")
	public String hrhomescreen(HttpSession session, Model model) {
		Long employeeId = (Long) session.getAttribute("EMP_ID");

		if (employeeId == null) {
			return "redirect:/ems/login";
		}
		return "hr-homescreen";
	}

	
	@GetMapping("/ems/employee-registration")
	public String empRegistrationForm(HttpSession session, Model model) {
		Long employeeId = (Long) session.getAttribute("EMP_ID");

		if (employeeId == null) {
			return "redirect:/ems/login";
		}
		return "employee-registration";
	}

	@PostMapping("/ems/employee-registration/submit")
	public String regEmpDetails(@RequestParam(name = "firstname" ,required = true)String firstname,@RequestParam(name="lastname", required = true)String lastname,@RequestParam(name = "email",required = true)String email,	
					@RequestParam(name="doj",required=true) Date doj,@RequestParam(name="dob",required=true) Date dob,@RequestParam(name="role", required=true) String role,
					@RequestParam(name="grade" , required=true) String grade,@RequestParam(name="deptname", required =true)String deptname,
					@RequestParam(name="team", required=true)String team,
					RedirectAttributes redirectAttribute,
					Model model) throws NoSuchAlgorithmException{	
		
		companyEmail = empreg.generateEmail(firstname, lastname);
		deptId = empreg.getDeptId(deptname);
		System.out.println("dept "+ deptId);
		if(deptId == 0) {
			redirectAttribute.addFlashAttribute("error", "Please enter a valid department");	
			return "redirect:/ems/employee-registration";
		}
		else {
		
			registerStatus = empreg.registerEmp(empreg.getFullName(firstname, lastname),companyEmail,doj,dob,role,grade, deptId,team,STATUS,email);
			empId = empreg.getEmpId(empreg.getFullName(firstname, lastname), dob);
			System.out.println(empId);
			password = empreg.getPassword();
			encodePass = encodeService.encodePassword(password);
			if(empId == 0){
				redirectAttribute.addFlashAttribute("error", "Please try again");
				return "redirect:/ems/employee-registration";
			}
			String loginDetails = empreg.updateLogin(empreg.getEmpUserName(firstname, lastname), encodePass,empId);
			empUserName = empreg.getUsername(empId);
			message = "Hello Welcome Aboard! Your employee Id is: " +String.valueOf(empId) + ", your username is " + empUserName+" ,password: " + password + " and company email: " + companyEmail;
			subject = "Welcome Onboard" + firstname;
					
			if(registerStatus.equals("success") && loginDetails.equals("success")) {
				
				sendEmail.sendMail(subject,message, email);
				redirectAttribute.addFlashAttribute("success", "The details of new employee have been saved successfully");
			} else {
				redirectAttribute.addFlashAttribute("error", "The details were not saved properly. Please try again");
				return "redirect:/ems/employee-registration";
			}
		}
		return "redirect:/ems/employee-registration";
	}

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
		if(status == "success" ) {
			
			redirectAttribute.addFlashAttribute("success", "Reimbursement approval succeeded");	
			return "redirect:/ems/reimbursement-approval";
		}
		else {
		
			redirectAttribute.addFlashAttribute("error", "Please try again");
			return "redirect:/ems/reimbursement-approval";
		}
	}
	
	@GetMapping("ems/emp-offboarding")
	public String offBoarding(HttpSession session, Model model) {
		Long employeeId = (Long) session.getAttribute("EMP_ID");

		if (employeeId == null) {
			return "redirect:/ems/login";
		}
		return "emp-offboarding";		
	}
	
	@PostMapping("/ems/emp-offboarding/submit")
	public String offBoardingSubmit(@RequestParam(name = "employeeId" ,required = true)Long employeeId,
		RedirectAttributes redirectAttribute,
		Model model){
		
			fullAndFinal = offBoardService.calculateFNF(employeeId);
			message = "Hello, your FNF is " + fullAndFinal;
			subject = "Wish you good luck!";
			personalEmail = offBoardService.getEMail(employeeId);
			System.out.println(personalEmail);
			sendEmail.sendMail(subject, message,personalEmail);
			
			System.out.println(fullAndFinal);
			offBoardService.disableUser(employeeId);
			offBoardService.offBoardEmp(employeeId);
						
			return "redirect:/ems/emp-offboarding";	
	}
	
}