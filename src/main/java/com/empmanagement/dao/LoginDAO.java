package com.empmanagement.dao;

public interface LoginDAO {
	public String getPasswordFromDatabase(String userName);
	public String getId(String userName);
}
