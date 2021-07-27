package com.empmanagement.dao;

/**
 * Interface for Login DAO
 * @author Priti Sri Pandey
 */
public interface IAuthenticationDAO {

	public String getPasswordFromDatabase(String userName);
	public String updatePassword(Long empId, String password);

}
