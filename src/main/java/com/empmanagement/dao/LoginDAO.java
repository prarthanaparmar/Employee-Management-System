package com.empmanagement.dao;

public interface LoginDAO {

/*
 * Gets the password from database for the employee
 */
	public String getPasswordFromDatabase(String userName);
	public Long getEmpIDFromDatabase(String userName);

}
