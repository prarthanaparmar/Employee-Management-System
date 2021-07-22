package com.empmanagement.dao;

import java.sql.Date;

public interface IOffBoardingDao {
	
	Date getDateOfJoin(Long empId);
	String getEMail(Long empId);
	int offBoardEmp(Long empId);
	int disableUser(Long empId); 
}
