package com.empmanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.empmanagement.dao.ISalaryDAO;
import com.empmanagement.domain.Deductions;
import com.empmanagement.domain.Earnings;
import com.empmanagement.domain.Salary;
import com.empmanagement.domain.Taxes;
import com.empmanagement.serviceimpl.SalaryServiceImpl;

/**
 * 
 * @author Priti Sri Pandey
 *
 */
@ExtendWith(MockitoExtension.class)
public class SalaryServiceImplTest {
	@Mock
	private ISalaryDAO salaryDAO;

	@Mock
	IEarningCalculationService earningService;

	@Mock
	IDeductionService deductionService;

	@InjectMocks
	SalaryServiceImpl salaryService;

	private static final double MONTHLY_ALLOWANCE = 800;
	private static final double SHIFT_ALLOWANCE = 1200;
	private static final double BASIC_PAY = 6800.0;
	private static final double HRA = 2040;
	private static final double NET_PAY = 3240.0;
	private static final double TOTAL_TAX = 6800.0;
	private static final double PROFESSIONAL_TAX = 800.0;
	private static final Long EMPID = (long) 13011;

	@Test
	void getSalaryForEmployeeTest() {
		Taxes tax = new Taxes();
		tax.setProfessionalTax(PROFESSIONAL_TAX);
		tax.setIncomeTax(TOTAL_TAX);

		Deductions expectedDeductions = new Deductions();
		expectedDeductions.setProvidentFund(0);
		expectedDeductions.setTax(tax);

		Earnings earnings = new Earnings();
		earnings.setAllowances(MONTHLY_ALLOWANCE);
		earnings.setBasic(BASIC_PAY);
		earnings.setHra(HRA);
		earnings.setShiftAllowance(SHIFT_ALLOWANCE);

		Mockito.when(salaryDAO.getBasicSalary(EMPID)).thenReturn(BASIC_PAY);
		Mockito.when(salaryService.getBasicPayForEmployee(EMPID)).thenReturn(BASIC_PAY);
		Mockito.when(earningService.calculateTotalEarnings(BASIC_PAY, EMPID)).thenReturn(earnings);
		Mockito.when(deductionService.getTotalDeductions(EMPID, 10840)).thenReturn(expectedDeductions);

		Salary salary = salaryService.getSalaryForEmployee(EMPID);

		assertEquals(salary.getEarnings(), earnings);
		assertEquals(salary.getDeductions(), expectedDeductions);
		assertEquals(salary.getNetPay(), NET_PAY);
	}

	@Test
	void getBasicPayForEmployeeTest() {
		Taxes tax = new Taxes();
		tax.setProfessionalTax(PROFESSIONAL_TAX);
		tax.setIncomeTax(TOTAL_TAX);

		Deductions expectedDeductions = new Deductions();
		expectedDeductions.setProvidentFund(0);
		expectedDeductions.setTax(tax);

		Mockito.when(salaryDAO.getBasicSalary(EMPID)).thenReturn(BASIC_PAY);

		double returnedBasicPay = salaryService.getBasicPayForEmployee(EMPID);
		assertEquals(returnedBasicPay, BASIC_PAY);
	}

}
