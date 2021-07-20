package com.empmanagement.dao;

/**
 * Interface for Login DAO
 * @author Priti Sri Pandey
 */
public interface ILoginDAO {

	public String getPasswordFromDatabase(String userName);
	public Long getEmpIDFromDatabase(String userName);

}
