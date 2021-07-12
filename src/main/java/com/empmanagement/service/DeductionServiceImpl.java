package com.empmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.domain.Deductions;

public class DeductionServiceImpl implements DeductionService {
	

@Autowired
TaxCalculationService taxService;

	@Override
	public Deductions getTotalDeductions() {
		
		taxService.caculateIncomeTax(0);
		return null;

	}
	

}
