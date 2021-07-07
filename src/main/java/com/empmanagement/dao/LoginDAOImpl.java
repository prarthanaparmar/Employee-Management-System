package com.empmanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	String empPassword;

/*
 * Gets the password from database for the employee
 */
	public String getPasswordFromDatabase(String userName) {

		try {

			empPassword = jdbcTemplate.queryForObject("select empPassword from login where empUsername = ?",
					String.class, userName);

		} catch (Exception e) {

			System.err.println(e);
		}

		return empPassword;
	}


}
