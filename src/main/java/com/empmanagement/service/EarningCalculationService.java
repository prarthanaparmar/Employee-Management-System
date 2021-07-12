package com.empmanagement.service;

import com.empmanagement.domain.Earnings;

public interface EarningCalculationService {
	
	public Earnings calculateTotalEarnings(double basicPay);

}
