package com.empmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

/**
 * @author Priti Sri Pandey
 */
public class EarningsTest {

	private static final double MONTHLY_ALLOWANCE = 800;
	private static final double SHIFT_ALLOWANCE = 1200;
	private static final double BASIC_PAY = (long) 6800.0;
	private static final double HRA = (long) 2040;

	@Test
	public void getBasicTest() {
		Earnings earnings = new Earnings();
		earnings.setBasic(BASIC_PAY);
		assertEquals(earnings.getBasic(), BASIC_PAY);

	}

	@Test
	public void getHRATest() {
		Earnings earnings = new Earnings();
		earnings.setHra(HRA);
		assertEquals(earnings.getHra(), HRA);

	}

	@Test
	public void getAllowanceTest() {
		Earnings earnings = new Earnings();
		earnings.setAllowances(MONTHLY_ALLOWANCE);
		assertEquals(earnings.getAllowances(), MONTHLY_ALLOWANCE);

	}

	@Test
	public void getShiftAllowance() {
		Earnings earnings = new Earnings();
		earnings.setShiftAllowance(SHIFT_ALLOWANCE);
		assertEquals(earnings.getShiftAllowance(), SHIFT_ALLOWANCE);

	}
}
