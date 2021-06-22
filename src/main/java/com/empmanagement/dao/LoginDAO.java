package com.empmanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoginDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	String empPassword;

/*
 * Gets the password from database for the employee
 */
	public String getPasswordFromDatabase(String userName) {

		try {

			empPassword = jdbcTemplate.queryForObject("select password from employee where userName = ?",
					String.class, userName);

		} catch (Exception e) {

			System.err.println(e);
		}

		return empPassword;
	}


}
