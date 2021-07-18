package com.empmanagement.dao;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.empmanagement.domain.InvestmentDeclaration;

@Repository
public class InvestmentDeclarationDAOImpl implements InvestmentDeclarationDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	String dbSaveStatus;
	InvestmentDeclaration investment = null;

	/*
	 * Gets the employee's investment declaration from database
	 */
	@Override
	public InvestmentDeclaration getInvestmentDeclaration(Long empId) {

		try {

			investment = jdbcTemplate.queryForObject(
					"SELECT homeLoanInterest, lifeInsuranceInvestment, mutualFundInvestment FROM investment_declaration where empId = ?",
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

			int rowsUpdatedInDBTable = jdbcTemplate.update(
					"INSERT INTO investment_declaration(empId, homeLoanInterest, lifeInsuranceInvestment, mutualFundInvestment) VALUES (?, ? ,?, ?) ON DUPLICATE KEY UPDATE empId = values(empId), homeLoanInterest = values(homeLoanInterest), lifeInsuranceInvestment = values(lifeInsuranceInvestment), mutualFundInvestment = values(mutualFundInvestment)",
					empId, homeLoanInterest, lifeInsuranceInvestment, mutualFundInvestment);
			System.out.println("Successfully updated " + rowsUpdatedInDBTable);

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
