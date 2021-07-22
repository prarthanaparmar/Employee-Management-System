package com.empmanagement.service;

import com.empmanagement.domain.Salary;

/**
 * @author Priti Sri Pandey
 */
public interface ISalaryService {

	/*
	 * Returns the total salary for an employee
	 */
	public double getBasicPayForEmployee(Long empId);

	public Salary getSalaryForEmployee(Long empId);

}
