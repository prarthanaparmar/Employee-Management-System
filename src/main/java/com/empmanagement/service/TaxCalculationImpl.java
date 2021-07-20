package com.empmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.domain.InvestmentDeclaration;

/**
 * This class is the service layer implementation of calculating total taxes
 * @author Priti Sri Pandey
 *
 */
@Service
public class TaxCalculationImpl implements ITaxCalculationService {

	@Autowired
	IInvestmentDeclarationService investmentService;
	
	double incomeTax = 0;
	double professionaltax = 0;
	double totalTaxableEarning = 0;
	
	InvestmentDeclaration investments = null;
	
	@Override
	public double caculateIncomeTax(Long empId, double totalEarnings) {
		
		investments = investmentService.getInvestmentDeclaration(empId);
		double totalAnnualInvestment = investments.getHomeLoanInterest() + investments.getLifeInsuranceInvestment() + investments.getMutualFundInvestment();
		double totalMonthlyInvestment = totalAnnualInvestment/12;
		
		totalTaxableEarning = totalEarnings - totalMonthlyInvestment;
		
		if(totalTaxableEarning < 15000) {
			incomeTax = 0;
		} else if (totalTaxableEarning < 20000 && totalTaxableEarning > 15000) {
			incomeTax = 0.05 * totalEarnings;
		} else if (totalTaxableEarning < 30000 && totalTaxableEarning > 20000) {
			incomeTax = 0.1 * totalTaxableEarning;
		} else {
			incomeTax = 0.2 * totalTaxableEarning;
		}
		return incomeTax;
	}

	@Override
	public double calculateProfessionalTax(double basicSalary) {

		professionaltax = 0.02 * basicSalary;
		return professionaltax;
	}


	
	

}
