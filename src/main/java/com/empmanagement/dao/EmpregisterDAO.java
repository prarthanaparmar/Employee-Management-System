	package com.empmanagement.dao;

import java.sql.Date;

public interface EmpregisterDAO {
	
	public String registerEmp(String name, String email,Date doj,Date dob,String role,String grade,int deptId,String team);
	public int getDeptId(String deptname);
	public String loginDetails(String username, String password, int empId);
	public int getEmpId(String empName, Date DOB);

}