package com.empmanagement.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.empmanagement.controller.LoginController;
import com.empmanagement.dao.LoginDAO;
import com.empmanagement.service.LoginService;

@SpringBootApplication
@ComponentScan(basePackageClasses = { LoginController.class, LoginDAO.class, LoginService.class })
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

}
