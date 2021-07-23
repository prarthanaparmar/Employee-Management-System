package com.empmanagement.service;

import java.security.NoSuchAlgorithmException;

public interface IEmpRegService {
	
	Integer getDeptId(String deptname);
	String generateEmail(String firstname, String lastname);
	String getFullName(String firstname, String lastname);
	String getEmpUserName(String firstname, String lastname);
	String getPassword() throws NoSuchAlgorithmException;
	
}
