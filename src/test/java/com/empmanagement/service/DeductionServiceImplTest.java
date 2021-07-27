package com.empmanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.empmanagement.domain.Deductions;
import com.empmanagement.domain.Taxes;
import com.empmanagement.serviceimpl.DeductionServiceImpl;

/**
 * 
 * @author Priti Sri Pandey
 *
 */
@ExtendWith(MockitoExtension.class)
public class DeductionServiceImplTest {

	@Mock
	ITaxCalculationService taxService;

	@InjectMocks
	DeductionServiceImpl deductionService;

	private static final double TOTAL_EARNINGS = 40000;
	private static final double TOTAL_TAX = (long) 6800.0;
	private static final double PROFESSIONAL_TAX = (long) 800.0;
	private static final Long EMPID = (long) 13011;

	@Test
	void getTotalDeductions() {
		Taxes tax = new Taxes();
		tax.setProfessionalTax(PROFESSIONAL_TAX);
		tax.setIncomeTax(TOTAL_TAX);
		
		Deductions expectedDeductions = new Deductions();
		expectedDeductions.setProvidentFund(0);
		expectedDeductions.setTax(tax);
		
		Mockito.when(taxService.calculateProfessionalTax(TOTAL_EARNINGS)).thenReturn(PROFESSIONAL_TAX);
		Mockito.when(taxService.caculateIncomeTax(EMPID, TOTAL_EARNINGS)).thenReturn(TOTAL_TAX);
		Deductions totalDeductions = deductionService.getTotalDeductions(EMPID, TOTAL_EARNINGS);
		assertEquals(totalDeductions.getTax().getIncomeTax(), TOTAL_TAX);
		assertEquals(totalDeductions.getTax().getProfessionalTax(), PROFESSIONAL_TAX);
	}

}
