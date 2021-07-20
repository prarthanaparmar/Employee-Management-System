package com.empmanagement.domain;

/**
 * @author Priti Sri Pandey
 */
public class Deductions {
	private Taxes tax;
	private double providentFund;

	public Taxes getTax() {
		return tax;
	}

	public void setTax(Taxes tax) {
		this.tax = tax;
	}

	public double getProvidentFund() {
		return providentFund;
	}

	public void setProvidentFund(double providentFund) {
		this.providentFund = providentFund;
	}

}
