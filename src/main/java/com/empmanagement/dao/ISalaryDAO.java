package com.empmanagement.dao;

/**
 * Interface for salary DAO
 * @author Priti Sri Pandey
 */
public interface ISalaryDAO {

	public double getBasicSalary(Long empId);
	public double getMonthlyAllowance(Long empId);
	public double getShiftAllowance(Long empId);
	
}
