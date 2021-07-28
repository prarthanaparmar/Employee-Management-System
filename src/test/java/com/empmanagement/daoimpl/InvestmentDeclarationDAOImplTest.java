package com.empmanagement.daoimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.test.util.ReflectionTestUtils;

import com.empmanagement.daoimpl.InvestmentDeclarationDAOImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 
 * @author Priti Sri Pandey
 *
 */
@ExtendWith(MockitoExtension.class)
public class InvestmentDeclarationDAOImplTest {

	@Mock
	private JdbcTemplate jdbcTemplate;

	@InjectMocks
	private InvestmentDeclarationDAOImpl investmentDAO;

	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	private static final Long EMP_ID = (long) 13011;
	private static final Long HOME_LOAN_INTEREST = (long) 20000;
	private static final Long LIFE_INSURANCE_PREMIUM = (long) 40000;
	private static final Long MF_INVEST = (long) 12000;
	private static final String QUERY_SAVE_INVESTMENT_DECLARATION = "INSERT INTO investment_declaration(empId, homeLoanInterest, lifeInsuranceInvestment, mutualFundInvestment)"
			+ " VALUES (?, ? ,?, ?) ON DUPLICATE KEY "
			+ "UPDATE empId = values(empId), homeLoanInterest = values(homeLoanInterest), "
			+ "lifeInsuranceInvestment = values(lifeInsuranceInvestment), mutualFundInvestment = values(mutualFundInvestment)";

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(investmentDAO, "jdbcTemplate", jdbcTemplate);
	}

	@Test
	public void saveInvestmentDeclarationTestSuccess() {

		ReflectionTestUtils.setField(investmentDAO, "jdbcTemplate", jdbcTemplate);
		Mockito.when(jdbcTemplate.update(QUERY_SAVE_INVESTMENT_DECLARATION, EMP_ID, HOME_LOAN_INTEREST,
				LIFE_INSURANCE_PREMIUM, MF_INVEST)).thenReturn(1);

		String dbSaveStatus = investmentDAO.saveInvestmentDeclaration(EMP_ID, HOME_LOAN_INTEREST,
				LIFE_INSURANCE_PREMIUM, MF_INVEST);
		assertEquals(dbSaveStatus, SUCCESS);

	}

	@Test
	public void saveInvestmentDeclarationTestError() {

		ReflectionTestUtils.setField(investmentDAO, "jdbcTemplate", jdbcTemplate);
		Mockito.when(jdbcTemplate.update(QUERY_SAVE_INVESTMENT_DECLARATION, EMP_ID, HOME_LOAN_INTEREST,
				LIFE_INSURANCE_PREMIUM, MF_INVEST)).thenReturn(0);

		String dbSaveStatus = investmentDAO.saveInvestmentDeclaration(EMP_ID, HOME_LOAN_INTEREST,
				LIFE_INSURANCE_PREMIUM, MF_INVEST);
		assertEquals(dbSaveStatus, ERROR);

	}

}
