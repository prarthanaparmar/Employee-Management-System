package com.empmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

/**
 * @author Priti Sri Pandey
 */
public class DeductionsTest {

	private static final double TOTAL_TAX = (long) 6800.0;
	private static final double PROFESSIONAL_TAX = (long) 800.0;

	@Test
	public void getTaxTest() {
		Deductions deductions = new Deductions();

		Taxes tax = new Taxes();
		tax.setIncomeTax(TOTAL_TAX);
		tax.setProfessionalTax(PROFESSIONAL_TAX);

		deductions.setTax(tax);
		assertEquals(TOTAL_TAX, deductions.getTax().getIncomeTax());
		assertEquals(PROFESSIONAL_TAX, deductions.getTax().getProfessionalTax());

	}

	@Test
	public void getProvidentFundTest() {
		Deductions deductions = new Deductions();
		deductions.setProvidentFund(0);
		assertEquals(deductions.getProvidentFund(), 0);

	}
}
