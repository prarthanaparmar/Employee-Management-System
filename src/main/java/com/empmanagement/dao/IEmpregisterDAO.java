package com.empmanagement.dao;

import java.sql.Date;
/**
 * Interface for EmpRegister DAO
 * @author Prarthanaben Parmar
 */

public interface IEmpregisterDAO {
	
	String registerEmp(String name, String email,Date doj,Date dob,String role,String grade,int deptId,String team,String status,String personalEmail);
	int getDeptId(String deptname);
	String loginDetails(String username, String password, Long empId);
	Long getEmpId(String empName, Date DOB);
	String getUsername(Long empId);
	
}