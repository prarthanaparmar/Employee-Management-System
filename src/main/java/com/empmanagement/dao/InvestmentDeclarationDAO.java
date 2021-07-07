package com.empmanagement.dao;

public interface InvestmentDeclarationDAO {

/*
 * Gets the password from database for the employee
 */
	public String saveInvestmentDeclaration(Long empId, Long homeLoanInterest, Long lifeInsuranceInvestment, Long mutualFundInvestment);
}
