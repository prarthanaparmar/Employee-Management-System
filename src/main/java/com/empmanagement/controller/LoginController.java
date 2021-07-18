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
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/ems/login";
	}

	@PostMapping("/ems/login/authenticate")
	public String loginSubmit(@RequestParam(name = "userName", required = true) String userName,
			@RequestParam(name = "password", required = true) String password, RedirectAttributes redirectAttribute,
			HttpServletRequest request, Model model) {

		boolean isPasswordValid = loginService.validatePassword(userName, password);

		if (isPasswordValid) {
			Long empId = loginService.getEmpID(userName);
			
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
	public String homePage() {
		return "home-screen";
	}
}
