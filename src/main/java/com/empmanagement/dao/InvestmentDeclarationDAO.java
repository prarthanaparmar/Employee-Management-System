package com.empmanagement.dao;

public interface InvestmentDeclarationDAO {

/*
 * Saves the employee investment declaration into database
 */
	public String saveInvestmentDeclaration(Long empId, Long homeLoanInterest, Long lifeInsuranceInvestment, Long mutualFundInvestment);
}
