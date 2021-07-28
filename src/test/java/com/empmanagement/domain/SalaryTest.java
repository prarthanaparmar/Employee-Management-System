package com.empmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

/**
 * @author Priti Sri Pandey
 */
public class SalaryTest {

	private static final double MONTHLY_ALLOWANCE = 800;
	private static final double SHIFT_ALLOWANCE = 1200;
	private static final double BASIC_PAY = (long) 6800.0;
	private static final double HRA = (long) 2040;

	@Test
	public void getEarningsTest() {
		Earnings earnings = new Earnings();
		earnings.setBasic(BASIC_PAY);
		earnings.setHra(HRA);
		earnings.setAllowances(MONTHLY_ALLOWANCE);
		earnings.setShiftAllowance(SHIFT_ALLOWANCE);

		Salary salary = new Salary();
		salary.setEarnings(earnings);
		Earnings returnedEarning = salary.getEarnings();
		assertEquals(earnings.getAllowances(), returnedEarning.getAllowances());

	}

	@Test
	public void getDeductionsTest() {

		Deductions deductions = new Deductions();
		deductions.setProvidentFund(0);
		deductions.setTax(null);

		Salary salary = new Salary();
		salary.setDeductions(deductions);
		Deductions returnedDeduction = salary.getDeductions();
		assertEquals(deductions.getTax(), returnedDeduction.getTax());

	}

	@Test
	public void getNetPayTest() {

		Salary salary = new Salary();
		salary.setNetPay(BASIC_PAY);
		double netPay = salary.getNetPay();
		assertEquals(netPay, BASIC_PAY);

	}
}
