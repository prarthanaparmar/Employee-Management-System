package com.empmanagement.service;

public interface IOffBoardingService {

	double calculateFNF(Long empId);
	String offBoardEmp(Long empId);
	String disableUser(Long empId);
	String getEMail(Long empId);
}
