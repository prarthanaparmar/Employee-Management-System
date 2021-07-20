package com.empmanagement.service;

import com.empmanagement.domain.InvestmentDeclaration;

/**
 * Interface for Earning Calculation services
 * @author Priti Sri Pandey
 */
public interface IInvestmentDeclarationService {
	
	public InvestmentDeclaration getInvestmentDeclaration(Long empId);
	public String saveInvestmentDeclaration(Long empId, Long homeLoanInterest, Long lifeInsuranceInvestment, Long mutualFundInvestment);
	
	

}
