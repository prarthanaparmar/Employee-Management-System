package com.empmanagement.domain;

public class InvestmentDeclaration {
	
	Long homeLoanInterest;
	Long lifeInsuranceInvestment;
	Long mutualFundInvestment;

	public Long getHomeLoanInterest() {
		return homeLoanInterest;
	}
	public void setHomeLoanInterest(Long homeLoanInterest) {
		this.homeLoanInterest = homeLoanInterest;
	}
	public Long getLifeInsuranceInvestment() {
		return lifeInsuranceInvestment;
	}
	public void setLifeInsuranceInvestment(Long lifeInsuranceInvestment) {
		if(lifeInsuranceInvestment < 200000) {
		this.lifeInsuranceInvestment = lifeInsuranceInvestment;
		}
		
	}
	public Long getMutualFundInvestment() {
		return mutualFundInvestment;
	}
	public void setMutualFundInvestment(Long mutualFundInvestment) {
		this.mutualFundInvestment = mutualFundInvestment;
	}
	

}
