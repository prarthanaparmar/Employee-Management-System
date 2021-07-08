package com.empmanagement.controller;

import com.empmanagement.domain.EmployeeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empmanagement.dao.LoginDAO;
import com.empmanagement.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;


	@GetMapping("/ems/login")
	public String loginForm() {
		return "login-screen";
	}
	
	@GetMapping("/ems/logout")
	public String logOut() {
		return "redirect:/ems/login";
	}

	@PostMapping("/ems/home")
	public String loginSubmit(@RequestParam(name = "userName", required = true) String userName,
			@RequestParam(name = "password", required = true) String password, 
			RedirectAttributes redirectAttribute,
			Model model) {

		boolean isPasswordValid = loginService.validatePassword(userName, password);

		if(isPasswordValid) {
			loginService.setEmployeeId(userName);
			return "home-screen";
		} else {
			redirectAttribute.addFlashAttribute("error", "Password provided by you is incorrect, Please try again.");
			return "redirect:/ems/login";
		}
	}
}
