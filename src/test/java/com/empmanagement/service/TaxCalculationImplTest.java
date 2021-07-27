package com.empmanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.empmanagement.dao.IInvestmentDeclarationDAO;
import com.empmanagement.domain.InvestmentDeclaration;
import com.empmanagement.serviceimpl.TaxCalculationImpl;

/**
 * 
 * @author Priti Sri Pandey
 *
 */
@ExtendWith(MockitoExtension.class)
public class TaxCalculationImplTest {

	@Mock
	private IInvestmentDeclarationDAO investmentDAO;

	@Mock
	IInvestmentDeclarationService investmentDeclarationService;

	@InjectMocks
	TaxCalculationImpl taxCalculationService;

	private static final double TOTAL_EARNINGS = 40000;
	private static final double BASIC_PAY = 40000;
	private static final Long HOME_LOAN_INTEREST = (long) 20000;
	private static final Long LIFE_INSURANCE_PREMIUM = (long) 40000;
	private static final Long MF_INVEST = (long) 12000;
	private static final double TOTAL_TAX = (long) 6800.0;
	private static final double PROFESSIONAL_TAX = (long) 800.0;
	private static final Long EMPID = (long) 13011;

	@Test
	void caculateIncomeTaxTest() {
		InvestmentDeclaration investment = new InvestmentDeclaration(HOME_LOAN_INTEREST, LIFE_INSURANCE_PREMIUM,
				MF_INVEST);
		Mockito.when(investmentDeclarationService.getInvestmentDeclaration(EMPID)).thenReturn(investment);
		double incomeTax = taxCalculationService.caculateIncomeTax(EMPID, TOTAL_EARNINGS);
		assertEquals(incomeTax, TOTAL_TAX);
	}

	@Test
	void calculateProfessionalTaxTest() {
		double incomeTax = taxCalculationService.calculateProfessionalTax(BASIC_PAY);
		assertEquals(incomeTax, PROFESSIONAL_TAX);
	}

}
