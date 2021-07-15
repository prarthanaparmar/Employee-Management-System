package com.empmanagement.service;

import com.empmanagement.domain.Earnings;

public interface EarningCalculationService {
	
	public Earnings calculateTotalEarnings(double basicPay, Long empId);
	public double getHRAForEmp(double basicPay);
	public double getMonthlyAllowances(long empId);
	public double getShiftAllowance(long empId);

}
