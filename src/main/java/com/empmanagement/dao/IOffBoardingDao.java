package com.empmanagement.dao;

import java.sql.Date;

public interface IOffBoardingDao {
	
	Date getDateOfJoin(Long empId);
	String getEMail(Long empId);
	String offBoardEmp(Long empId);
	String disableUser(Long empId); 
}
