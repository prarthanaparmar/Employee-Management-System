package com.empmanagement.service;

import org.springframework.stereotype.Service;

import com.empmanagement.domain.Earnings;

@Service
public class EarningCalculationServiceImpl implements EarningCalculationService {
	double hra = 0;
	double allowances = 0;
	
	
	@Override
	public Earnings calculateTotalEarnings(double basicPay) {
		
		Earnings earnings = new Earnings();
		earnings.setBasic(basicPay);
		earnings.setHra(hra);
		earnings.setAllowances(allowances);
		
		return earnings;
		
	}

}
