package com.empmanagement.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.IOffBoardingDao;
import com.empmanagement.dao.IReimbursementDao;
import com.empmanagement.dao.OffBoardingDaoImpl;
import com.empmanagement.dao.ReimbursementDaoImpl;

@Service
public class OffBoardingServiceImpl implements IOffBoardingService{
	
	@Autowired
	IOffBoardingDao offBoardDao;
	
	@Autowired
	ISalaryService salaryService;
	
	private double fullAndFinal;
	private double monthlySalary;
	private int workedFor;
	private Date dateOfJoin;
	static final double GRATUITY = 0.57;
	
	@Override
	public double calculateFNF(Long empId) {
		
		dateOfJoin = offBoardDao.getDateOfJoin(empId);
		LocalDate localdoj = new java.sql.Date(dateOfJoin.getTime()).toLocalDate();
		workedFor = Period.between(localdoj,LocalDate.now()).getYears();
		monthlySalary = salaryService.getSalaryForEmployee(empId).getNetPay();	
		fullAndFinal = workedFor*GRATUITY*monthlySalary;
		
		return fullAndFinal;
	}
}
