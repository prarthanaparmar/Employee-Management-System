package com.empmanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.empmanagement.dao.ISalaryDAO;
import com.empmanagement.domain.Earnings;
import com.empmanagement.serviceimpl.EarningCalculationServiceImpl;

/**
 * 
 * @author Priti Sri Pandey
 *
 */
@ExtendWith(MockitoExtension.class)
public class EarningCalculationServiceImplTest {
	@Mock
	private ISalaryDAO salaryDAO;
	
	@Mock
	ITaxCalculationService taxService;

	@InjectMocks
	EarningCalculationServiceImpl earningService;

	private static final double MONTHLY_ALLOWANCE = 800;
	private static final double SHIFT_ALLOWANCE = 1200;
	private static final double BASIC_PAY = (long) 6800.0;
	private static final double HRA = (long) 2040;
	private static final Long EMPID = (long) 13011;

	@Test
	void calculateTotalEarningsTest() {
		Mockito.when(salaryDAO.getMonthlyAllowance(EMPID))
		.thenReturn(MONTHLY_ALLOWANCE);
		
		Mockito.when(salaryDAO.getShiftAllowance(EMPID))
		.thenReturn((double) 0);

		Earnings returnedEarnings = earningService.calculateTotalEarnings(BASIC_PAY, EMPID);
		assertEquals(returnedEarnings.getAllowances(), MONTHLY_ALLOWANCE );
		assertEquals(returnedEarnings.getShiftAllowance(), 0);
	}
	
	@Test
	void getMonthlyAllowancesTest() {
		Mockito.when(salaryDAO.getMonthlyAllowance(EMPID))
		.thenReturn(MONTHLY_ALLOWANCE);

		double returned_allowance = earningService.getMonthlyAllowances(EMPID);
		assertEquals(returned_allowance, MONTHLY_ALLOWANCE );
	}
	
	@Test
	void getHRAForEmpTest() {
		double hra = earningService.getHRAForEmp(BASIC_PAY);
		assertEquals(hra, HRA );
	}
	
	@Test
	void getShiftAllowanceTest() {
		Mockito.when(salaryDAO.getShiftAllowance(EMPID))
		.thenReturn(SHIFT_ALLOWANCE);
		
		double shiftAllowance = earningService.getShiftAllowance(EMPID);
		assertEquals(SHIFT_ALLOWANCE, shiftAllowance );
	}

}
