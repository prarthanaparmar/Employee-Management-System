package com.empmanagement.service;

import com.empmanagement.domain.Salary;

public interface SalaryService {

/*
 * Returns the total salary for an employee
 */
	public double getBasicPayForEmployee(Long empId);
	public Salary getSalaryForEmployee(Long empId);


}
