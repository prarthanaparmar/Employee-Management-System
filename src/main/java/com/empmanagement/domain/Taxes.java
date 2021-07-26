package com.empmanagement.domain;

import com.empmanagement.util.DecimalFormatter;

/**
 * @author Priti Sri Pandey
 */
public class Taxes {
	private double incomeTax;
	private double professionalTax;

	public double getIncomeTax() {
		return incomeTax;
	}
	public void setIncomeTax(double incomeTax) {
		this.incomeTax = DecimalFormatter.format(incomeTax);
	}
	public double getProfessionalTax() {
		return professionalTax;
	}
	public void setProfessionalTax(double professionalTax) {
		this.professionalTax = DecimalFormatter.format(professionalTax);
	}
	
}
