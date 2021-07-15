package com.empmanagement.domain;

public class InvestmentDeclaration {

	Long homeLoanInterest;
	Long lifeInsuranceInvestment;
	Long mutualFundInvestment;

	public InvestmentDeclaration(long homeLoanInterest, long lifeInsuranceInvestment, long mutualFundInvestment) {
		this.homeLoanInterest = homeLoanInterest;
		this.lifeInsuranceInvestment = lifeInsuranceInvestment;
		this.mutualFundInvestment = mutualFundInvestment;
	}

	public Long getHomeLoanInterest() {
		return homeLoanInterest;
	}

	public void setHomeLoanInterest(Long homeLoanInterest) {
		if (homeLoanInterest < 60000) {
			this.homeLoanInterest = homeLoanInterest;
		}
	}

	public Long getLifeInsuranceInvestment() {
		return lifeInsuranceInvestment;
	}

	public void setLifeInsuranceInvestment(Long lifeInsuranceInvestment) {
		if (lifeInsuranceInvestment < 30000) {
			this.lifeInsuranceInvestment = lifeInsuranceInvestment;
		}

	}

	public Long getMutualFundInvestment() {
		return mutualFundInvestment;
	}

	public void setMutualFundInvestment(Long mutualFundInvestment) {
		if (mutualFundInvestment < 25000) {
			this.mutualFundInvestment = mutualFundInvestment;
		}
	}

}
