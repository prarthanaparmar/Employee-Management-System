package com.empmanagement.domain;

/**
 * @author Priti Sri Pandey
 */
public class Earnings {
	private double basic = 0;
	private double hra = 0;
	private double allowances = 0;
	private double shiftAllowance = 0;

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getAllowances() {
		return allowances;
	}

	public void setAllowances(double allowances) {
		this.allowances = allowances;
	}

	public double getShiftAllowance() {
		return shiftAllowance;
	}

	public void setShiftAllowance(double shiftAllowance) {
		this.shiftAllowance = shiftAllowance;
	}

}
