package com.empmanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * This class in the data access implementation for fetching and updating login and authentication related data in the database
 * @author Priti Sri Pandey
 *
 */
@Repository
public class LoginDAOImpl implements ILoginDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	String empPassword;
	Long empId;

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
	
	
	/*
	 * Gets the empId from database for the userName
	 */
	public Long getEmpIDFromDatabase(String userName) {

		try {

			empId = jdbcTemplate.queryForObject("select empId from login where empUsername = ?",
					Long.class, userName);

		} catch (Exception e) {

			System.err.println(e);
		}

		return empId;
	}


}
