package com.empmanagement.dao;

public interface SalaryDAO {

	public double getBasicSalary(Long empId);
	public double getMonthlyAllowance(Long empId);
	public double getShiftAllowance(Long empId);
	
}
