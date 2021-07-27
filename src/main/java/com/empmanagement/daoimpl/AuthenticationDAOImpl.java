package com.empmanagement.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.empmanagement.dao.IAuthenticationDAO;

/**
 * This class in the data access implementation for fetching and updating login
 * and authentication related data in the database
 * 
 * @author Priti Sri Pandey
 *
 */
@Repository
public class AuthenticationDAOImpl implements IAuthenticationDAO {

	private static final String QUERY_GET_PASSWORD = "select empPassword from login where empUsername = ?";
	private static final String QUERY_UPDATE_PASSWORD = "UPDATE login SET empPassword = ? WHERE empId = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	String empPassword;

	/*
	 * Gets the password from database for the employee
	 */
	public String getPasswordFromDatabase(String userName) {

		try {

			empPassword = jdbcTemplate.queryForObject(QUERY_GET_PASSWORD, String.class, userName);

		} catch (Exception e) {

			System.err.println(e);
		}

		return empPassword;
	}

	@Override
	public String updatePassword(Long empId, String password) {
		String dbSaveStatus = "error";
		try {

			int rowsUpdatedInDBTable = jdbcTemplate.update(QUERY_UPDATE_PASSWORD, password, empId);

			if (rowsUpdatedInDBTable > 0) {
				dbSaveStatus = "success";
			}

		} catch (Exception e) {
			e.printStackTrace();
			dbSaveStatus = "error";
		}

		return dbSaveStatus;
	}

}
