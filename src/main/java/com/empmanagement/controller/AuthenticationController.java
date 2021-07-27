package com.empmanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empmanagement.service.IAuthenticationService;
import com.empmanagement.service.IEmployeeDirectoryService;

/**
 * This classes takes care of login and authentication related operations
 * 
 * @author Priti Sri Pandey
 *
 */
@Controller
public class AuthenticationController {

	@Autowired
	private IAuthenticationService authenticationService;
	
	@Autowired
	private IEmployeeDirectoryService empDirectoryService;

	@GetMapping("/ems/login")
	public String loginForm() {
		return "login-screen";
	}

	@GetMapping("/ems/logout")
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/ems/login";
	}

	@GetMapping("/ems/changepassword")
	public String changePassword() {
		return "change-password";
	}

	@PostMapping("/ems/updatepassword")
	public String changePassword(@RequestParam(name = "empId", required = true) Long empId,
			@RequestParam(name = "password", required = true) String password, RedirectAttributes redirectAttribute) {
		String passwordChangeStatus = authenticationService.updatePassword(empId, password);
		if (passwordChangeStatus.equals("success")) {
			redirectAttribute.addFlashAttribute("success", "Your Password has been changed successfully. ");
		} else {
			redirectAttribute.addFlashAttribute("error", "Sorry, Your Password could not be saved. Please tru again. ");
		}
		return "redirect:/ems/changepassword";
	}

	@PostMapping("/ems/login/authenticate")
	public String loginSubmit(@RequestParam(name = "userName", required = true) String userName,
			@RequestParam(name = "password", required = true) String password, RedirectAttributes redirectAttribute,
			HttpServletRequest request, Model model) {

		boolean isPasswordValid = authenticationService.validatePassword(userName, password);

		if (isPasswordValid) {
			Long empId = empDirectoryService.getEmpID(userName);

			Long employeeId = (Long) request.getSession().getAttribute("EMP_ID");
			if (employeeId == null) {
				employeeId = empId;
				request.getSession().setAttribute("EMP_ID", employeeId);
			}
			employeeId = empId;
			request.getSession().setAttribute("EMP_ID", employeeId);

			return "redirect:/ems/home";
		} else {
			redirectAttribute.addFlashAttribute("error", "Password provided by you is incorrect, Please try again.");
			return "redirect:/ems/login";
		}
	}

	@GetMapping("/ems/home")
	public String homePage(HttpSession session, Model model) {
		Long employeeId = (Long) session.getAttribute("EMP_ID");

		if (employeeId == null) {
			return "redirect:/ems/login";
		}
		String empRole = empDirectoryService.getEmployeeRole(employeeId);
		model.addAttribute("empRole", empRole);
		
		return "home-screen";
	}
}
