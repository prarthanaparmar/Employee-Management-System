package com.empmanagement.service;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;

public interface IEmpRegService {
	
	String registerEmp(String name,String email,Date doj,Date dob, String role,String grade,int deptId,String team,String status,String personalEmail);
	Integer getDeptId(String deptname);
	String generateEmail(String firstname, String lastname);
	String getFullName(String firstname, String lastname);
	String getEmpUserName(String firstname, String lastname);
	String getPassword() throws NoSuchAlgorithmException;
	String getUsername(Long empId);
	Long getEmpId(String empName, Date DOB);
	String updateLogin(String username, String password, Long empId);
}
