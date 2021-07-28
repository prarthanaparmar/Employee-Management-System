package com.empmanagement.serviceimpl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.IOffBoardingDao;
import com.empmanagement.service.IOffBoardingService;
import com.empmanagement.service.ISalaryService;
/**
 *This class contains the bsiness logic for Off boarding full and final calculation
 *an of Employee
 *
 * @author Prarthanaben Parmar
 *
 */


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
	private String status;
	
	@Override
	public double calculateFNF(Long empId) {
		
		dateOfJoin = offBoardDao.getDateOfJoin(empId);
		LocalDate localdoj = new java.sql.Date(dateOfJoin.getTime()).toLocalDate();
		workedFor = Period.between(localdoj,LocalDate.now()).getYears();
		monthlySalary = salaryService.getSalaryForEmployee(empId).getNetPay();	
		fullAndFinal = workedFor*GRATUITY*monthlySalary;
		
		return fullAndFinal;
	}

	@Override
	public String offBoardEmp(Long empId) {
		
		status = offBoardDao.offBoardEmp(empId);
		return status;
		
	}

	@Override
	public String disableUser(Long empId) {
		
		status = offBoardDao.disableUser(empId);
		return status;
	}

	@Override
	public String getEMail(Long empId) {
	
		String mail = offBoardDao.getEMail(empId);
		return mail;
	}
}
