package com.empmanagement.service;

public interface EmpReg {
	
	public Integer getDeptId(String deptname);
	public String generateEmail(String firstname, String lastname);
	public String getFullName(String firstname, String lastname);
	public String getEmpUserName(String firstname, String lastname);
	public String getPassword();

}
