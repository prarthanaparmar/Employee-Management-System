package com.empmanagement.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.empmanagement.dao.IInvestmentDeclarationDAO;
import com.empmanagement.domain.InvestmentDeclaration;

/**
 * This is the DAO class to get investment related data from the database
 * 
 * @author Priti Sri Pandey
 *
 */
@Repository
public class InvestmentDeclarationDAOImpl implements IInvestmentDeclarationDAO {
	private static final String QUERY_INVESTMENT_DECLARATION = "SELECT homeLoanInterest, lifeInsuranceInvestment, mutualFundInvestment FROM investment_declaration where empId = ?";
	private static final String QUERY_SAVE_INVESTMENT_DECLARATION = "INSERT INTO investment_declaration(empId, homeLoanInterest, lifeInsuranceInvestment, mutualFundInvestment)"
			+ " VALUES (?, ? ,?, ?) ON DUPLICATE KEY "
			+ "UPDATE empId = values(empId), homeLoanInterest = values(homeLoanInterest), "
			+ "lifeInsuranceInvestment = values(lifeInsuranceInvestment), mutualFundInvestment = values(mutualFundInvestment)";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	String dbSaveStatus = "error";
	InvestmentDeclaration investment = null;

	/*
	 * Gets the employee's investment declaration from database
	 */
	@Override
	public InvestmentDeclaration getInvestmentDeclaration(Long empId) {

		try {

			investment = jdbcTemplate.queryForObject(QUERY_INVESTMENT_DECLARATION,
					(rs, rowNum) -> new InvestmentDeclaration(rs.getLong("homeLoanInterest"),
							rs.getLong("lifeInsuranceInvestment"), rs.getLong("mutualFundInvestment")),
					empId);

		} catch (EmptyResultDataAccessException e) {

			investment = new InvestmentDeclaration(0, 0, 0);

		}

		catch (Exception e) {

			System.err.println(e);
		}
		return investment;
	}

	/*
	 * Saves the employee investment declaration into database
	 */
	public String saveInvestmentDeclaration(Long empId, Long homeLoanInterest, Long lifeInsuranceInvestment,
			Long mutualFundInvestment) {

		try {

			int rowsUpdatedInDBTable = jdbcTemplate.update(QUERY_SAVE_INVESTMENT_DECLARATION, empId, homeLoanInterest,
					lifeInsuranceInvestment, mutualFundInvestment);

			if (rowsUpdatedInDBTable > 0) {
				dbSaveStatus = "success";
			}

		} catch (Exception e) {
			System.err.println(e);
			dbSaveStatus = "error";
		}

		return dbSaveStatus;
	}

}
