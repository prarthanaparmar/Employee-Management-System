
package com.empmanagement.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.empmanagement.dao.IInvestmentDeclarationDAO;
import com.empmanagement.domain.InvestmentDeclaration;
import com.empmanagement.serviceimpl.InvestmentDeclarationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author Priti Sri Pandey
 *
 */
@ExtendWith(MockitoExtension.class)
public class InvestmentDeclarationServiceImplTest {

	@Mock
	private IInvestmentDeclarationDAO investmentDAO;

	@InjectMocks
	InvestmentDeclarationServiceImpl investmentDeclarationService;

	private static final Long HOME_LOAN_INTEREST = (long) 20000;
	private static final Long LIFE_INSURANCE_PREMIUM = (long) 40000;
	private static final Long MF_INVEST = (long) 12000;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	private static final Long EMPID = (long) 13011;

	@Test
	void getInvestmentDeclaration() throws NoSuchAlgorithmException {
		InvestmentDeclaration investment = new InvestmentDeclaration(HOME_LOAN_INTEREST, LIFE_INSURANCE_PREMIUM, MF_INVEST);
		Mockito.when(investmentDAO.getInvestmentDeclaration(EMPID))
				.thenReturn(investment);
		InvestmentDeclaration returnedInvestmenetDeclaration = investmentDeclarationService.getInvestmentDeclaration(EMPID);
		assertEquals(investment, returnedInvestmenetDeclaration);
	}

	@Test
	void saveInvestmentDeclarationSuccess() throws NoSuchAlgorithmException {
		Mockito.when(investmentDAO.saveInvestmentDeclaration(EMPID, HOME_LOAN_INTEREST, LIFE_INSURANCE_PREMIUM, MF_INVEST ))
				.thenReturn(SUCCESS);
		String dbStatus = investmentDeclarationService.saveInvestmentDeclaration(EMPID, HOME_LOAN_INTEREST, LIFE_INSURANCE_PREMIUM, MF_INVEST);
		assertEquals(SUCCESS, dbStatus);
	}
	
	@Test
	void saveInvestmentDeclarationError() throws NoSuchAlgorithmException {
		Mockito.when(investmentDAO.saveInvestmentDeclaration(EMPID, HOME_LOAN_INTEREST, LIFE_INSURANCE_PREMIUM, MF_INVEST ))
				.thenReturn(ERROR);
		String dbStatus = investmentDeclarationService.saveInvestmentDeclaration(EMPID, HOME_LOAN_INTEREST, LIFE_INSURANCE_PREMIUM, MF_INVEST);
		assertEquals(ERROR, dbStatus);
	}

}