package com.empmanagement.service;

import org.springframework.stereotype.Service;

@Service
public class TaxCalculationImpl implements TaxCalculationService {

	double incomeTax = 0;
	double professionaltax = 0;
	
	@Override
	public double caculateIncomeTax(double basicSalary) {
		if(basicSalary < 15000) {
			incomeTax = 0;
		} else if (basicSalary < 20000 && basicSalary > 15000) {
			incomeTax = 0.05 * basicSalary;
		} else if (basicSalary < 30000 && basicSalary > 20000) {
			incomeTax = 0.1 * basicSalary;
		} else {
			incomeTax = 0.2 * basicSalary;
		}
		return incomeTax;
	}

	@Override
	public double calculateProfessionalTax(double basicSalary) {

		professionaltax = 0.02 * basicSalary;
		return professionaltax;
	}


	
	

}
