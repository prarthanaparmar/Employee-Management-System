package com.empmanagement.service;

import com.empmanagement.domain.Earnings;

/**
 * Interface for Earning Calculation services
 * @author Priti Sri Pandey
 */
public interface IEarningCalculationService {
	
	public Earnings calculateTotalEarnings(double basicPay, Long empId);
	public double getHRAForEmp(double basicPay);
	public double getMonthlyAllowances(long empId);
	public double getShiftAllowance(long empId);

}
