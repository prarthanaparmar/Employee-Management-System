package com.empmanagement.dao;

import com.empmanagement.domain.InvestmentDeclaration;

/**
 * Interface for Investment DAO
 * @author Priti Sri Pandey
 */
public interface IInvestmentDeclarationDAO {

/*
 * Saves the employee investment declaration into database
 */
	public String saveInvestmentDeclaration(Long empId, Long homeLoanInterest, Long lifeInsuranceInvestment, Long mutualFundInvestment);

/*
 * Gets the employee's investment declaration from database
 */
	public InvestmentDeclaration getInvestmentDeclaration(Long empId);
	
}
