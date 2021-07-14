package com.empmanagement.service;

import org.springframework.stereotype.Service;

import com.empmanagement.domain.InvestmentDeclaration;

public interface InvestmentDeclarationService {
	
	public InvestmentDeclaration getInvestmentDeclaration(Long empId);
	public String saveInvestmentDeclaration(Long empId, Long homeLoanInterest, Long lifeInsuranceInvestment, Long mutualFundInvestment);
	
	

}
