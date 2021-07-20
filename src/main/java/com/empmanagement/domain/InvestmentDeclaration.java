package com.empmanagement.domain;

/**
 * @author Priti Sri Pandey
 */
public class InvestmentDeclaration {

	private static final double HOME_LOAN_MAX_LIMIT = 15000;
	private static final double LIFE_INSURANCE_MAX_LIMIT = 30000;
	private static final double MUTUAL_FUND_MAX_LIMIT = 25000;
	
	private Long homeLoanInterest;
	private Long lifeInsuranceInvestment;
	private Long mutualFundInvestment;

	public InvestmentDeclaration(long homeLoanInterest, long lifeInsuranceInvestment, long mutualFundInvestment) {
		this.homeLoanInterest = homeLoanInterest;
		this.lifeInsuranceInvestment = lifeInsuranceInvestment;
		this.mutualFundInvestment = mutualFundInvestment;
	}

	public Long getHomeLoanInterest() {
		return homeLoanInterest;
	}

	public void setHomeLoanInterest(Long homeLoanInterest) {
		if (homeLoanInterest < HOME_LOAN_MAX_LIMIT) {
			this.homeLoanInterest = homeLoanInterest;
		}
	}

	public Long getLifeInsuranceInvestment() {
		return lifeInsuranceInvestment;
	}

	public void setLifeInsuranceInvestment(Long lifeInsuranceInvestment) {
		if (lifeInsuranceInvestment < LIFE_INSURANCE_MAX_LIMIT) {
			this.lifeInsuranceInvestment = lifeInsuranceInvestment;
		}

	}

	public Long getMutualFundInvestment() {
		return mutualFundInvestment;
	}

	public void setMutualFundInvestment(Long mutualFundInvestment) {
		if (mutualFundInvestment < MUTUAL_FUND_MAX_LIMIT) {
			this.mutualFundInvestment = mutualFundInvestment;
		}
	}

}
