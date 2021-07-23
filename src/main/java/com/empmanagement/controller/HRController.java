package com.empmanagement.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.security.auth.Subject;

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
import com.empmanagement.service.IOffBoardingService;
import com.empmanagement.service.EmpRegServiceImpl;
import com.empmanagement.service.IReimbursementService;
import com.empmanagement.service.ISendEmailService;
import com.empmanagement.service.OffBoardingServiceImpl;
import com.empmanagement.service.ReimbursementServiceImpl;
import com.empmanagement.service.SendEmailService;
import com.empmanagement.util.PasswordEncoder;
import com.sun.mail.handlers.message_rfc822;

@Controller
public class HRController {

	@Autowired
	private IEmpregisterDAO empRegDao;
	
	@Autowired
	private IEmpRegService empreg;
	
	@Autowired
	private IReimbursementService reimburseservice;
	
	@Autowired
	private IOffBoardingService offBoardService;
	
	@Autowired
	private ISendEmailService sendEmail;
	
	@Autowired
	private IOffBoardingDao offBoardDao;
	
	private String companyEmail;
	private String registerStatus;
	private Long empId;
	private double fullAndFinal;
	private String password;
	private String encodePass;
	private String message;
	private String subject;
	private String personalEmail;
	
	static final String STATUS = "active";
	
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
					Model model) throws NoSuchAlgorithmException{	
		
		companyEmail = empreg.generateEmail(firstname, lastname);
		registerStatus = empRegDao.registerEmp(empreg.getFullName(firstname, lastname),companyEmail,doj,dob,role,grade, empRegDao.getDeptId(deptname),team,STATUS,email);
		empId = empRegDao.getEmpId(empreg.getFullName(firstname, lastname), dob);
		password = empreg.getPassword();
		encodePass = PasswordEncoder.encodePassword(password);
		String loginDetails = empRegDao.loginDetails(empreg.getEmpUserName(firstname, lastname), encodePass,empId);
				
		if(registerStatus.equals("success") && loginDetails.equals("success")) {
			message = "Hello Welcome Aboard! Your employee Id is: " +String.valueOf(empId) +" ,password: " + password + " and company email: " + companyEmail;
			subject = "Welcome Onboard" + firstname;
			sendEmail.sendMail(subject,message, email);
			redirectAttribute.addFlashAttribute("Done", "The details of new wmployee have been saved successfully");
		} else {
	    redirectAttribute.addFlashAttribute("error", "The details were not saved properly. Please try again");
		}
		return "redirect:/ems/employee-registration";
	}

	@GetMapping("/ems/reimbursement-approval")
	public String reimbursementapproval() {
		return "reimbursement-approval";
	}
	
	@PostMapping("/ems/reimbursement-approval/submit")
	public String reimburseApproval(RedirectAttributes redirectAttribute,
			Model model) {
		
		reimburseservice.getAllRequests();
		
		return "redirect:/ems/reimbursement-approval";
	}
	
	@GetMapping("ems/emp-offboarding")
	public String offBoarding(){
		
		return "emp-offboarding";		
	}
	
	@PostMapping("/ems/emp-offboarding/submit")
	public String offBoardingSubmit(@RequestParam(name = "employeeId" ,required = true)Long employeeId,
		RedirectAttributes redirectAttribute,
		Model model){
		
			fullAndFinal = offBoardService.calculateFNF(employeeId);
			message = "Hello, your FNF is " + fullAndFinal;
			subject = "Wish you good luck!";
			personalEmail = offBoardDao.getEMail(employeeId);
			sendEmail.sendMail(subject, message,personalEmail);
			
			System.out.println(fullAndFinal);
			offBoardDao.disableUser(employeeId);
			offBoardDao.offBoardEmp(employeeId);
						
			return "redirect:/ems/emp-offboarding";	
	}
}