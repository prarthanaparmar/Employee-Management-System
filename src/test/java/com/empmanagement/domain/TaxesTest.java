package com.empmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

/**
 * @author Priti Sri Pandey
 */
public class TaxesTest {

	private static final double INCOME_TAX = (long) 6800.0;
	private static final double PROFESSIONAL_TAX = (long) 800.0;

	@Test
	public void getIncomeTaxTest() {

		Taxes tax = new Taxes();
		tax.setIncomeTax(INCOME_TAX);

		assertEquals(INCOME_TAX, tax.getIncomeTax());

	}

	@Test
	public void getProfessionalTax() {

		Taxes tax = new Taxes();
		tax.setIncomeTax(PROFESSIONAL_TAX);

		assertEquals(PROFESSIONAL_TAX, tax.getIncomeTax());

	}
}
