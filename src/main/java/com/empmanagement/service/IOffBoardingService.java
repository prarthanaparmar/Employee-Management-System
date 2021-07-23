package com.empmanagement.service;

import java.sql.Date;

public interface IOffBoardingService {

	double calculateFNF(Long empId);
	String offBoardEmp(Long empId);
	String disableUser(Long empId);
	String getEMail(Long empId);
}
