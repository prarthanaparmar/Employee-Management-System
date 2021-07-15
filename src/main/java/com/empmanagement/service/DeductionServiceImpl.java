package com.empmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.domain.Deductions;
import com.empmanagement.domain.Taxes;

@Service
public class DeductionServiceImpl implements DeductionService {

	@Autowired
	TaxCalculationService taxService;

	double incomeTax = 0;
	double professionalTax = 0;

	@Override
	public Deductions getTotalDeductions(double totalEarnings) {
		incomeTax = taxService.caculateIncomeTax(totalEarnings);
		professionalTax = taxService.calculateProfessionalTax(totalEarnings);

		Taxes totalTaxes = new Taxes();
		totalTaxes.setIncomeTax(incomeTax);
		totalTaxes.setProfessionalTax(professionalTax);

		Deductions totalDeductions = new Deductions();
		totalDeductions.setTax(totalTaxes);
		return totalDeductions;
	}

}
