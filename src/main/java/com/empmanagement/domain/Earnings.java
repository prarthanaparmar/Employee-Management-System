package com.empmanagement.domain;

import com.empmanagement.util.DecimalFormatter;

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
		this.basic = DecimalFormatter.format(basic);
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = DecimalFormatter.format(hra);
	}

	public double getAllowances() {
		return allowances;
	}

	public void setAllowances(double allowances) {
		this.allowances = DecimalFormatter.format(allowances);
	}

	public double getShiftAllowance() {
		return shiftAllowance;
	}

	public void setShiftAllowance(double shiftAllowance) {
		this.shiftAllowance = DecimalFormatter.format(shiftAllowance);
	}

}
