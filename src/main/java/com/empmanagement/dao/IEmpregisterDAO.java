	package com.empmanagement.dao;

import java.sql.Date;

public interface IEmpregisterDAO {
	
	String registerEmp(String name, String email,Date doj,Date dob,String role,String grade,int deptId,String team);
	int getDeptId(String deptname);
	String loginDetails(String username, String password, int empId);
	int getEmpId(String empName, Date DOB);

}