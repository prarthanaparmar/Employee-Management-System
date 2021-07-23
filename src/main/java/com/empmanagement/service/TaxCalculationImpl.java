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
	
	private static final double TAX_SLAB_A = 15000;
	private static final double TAX_SLAB_B = 20000;
	private static final double TAX_SLAB_C = 30000;
	
	private static final double incomeTaxRateA = 0.05;
	private static final double incomeTaxRateB = 0.1;
	private static final double incomeTaxRateC = 0.2;
	private static final double professionalTaxRate = 0.02;
	
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
		
		if(totalTaxableEarning < TAX_SLAB_A) {
			incomeTax = 0;
		} else if (totalTaxableEarning < TAX_SLAB_B && totalTaxableEarning > TAX_SLAB_A) {
			incomeTax = incomeTaxRateA * totalEarnings;
		} else if (totalTaxableEarning < TAX_SLAB_C && totalTaxableEarning > TAX_SLAB_B) {
			incomeTax = incomeTaxRateB * totalTaxableEarning;
		} else {
			incomeTax = incomeTaxRateC * totalTaxableEarning;
		}
		return incomeTax;
	}

	@Override
	public double calculateProfessionalTax(double basicSalary) {

		professionaltax = professionalTaxRate * basicSalary;
		return professionaltax;
	}


	
	

}
