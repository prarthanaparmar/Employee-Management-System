package com.empmanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InvestmentDeclarationDAOImpl implements InvestmentDeclarationDAO {
    @Autowired
	private JdbcTemplate jdbcTemplate;
	String dbSaveStatus;

/*
 * Gets the password from database for the employee
 */
	public String saveInvestmentDeclaration(Long empId, Long homeLoanInterest, Long lifeInsuranceInvestment, Long mutualFundInvestment) {

		try {

			int rowsUpdatedInUserTable = jdbcTemplate.update(
					"INSERT INTO investment_declaration(empId, homeLoanInterest, lifeInsuranceInvestment, mutualFundInvestment) VALUES (?, ? ,?, ?)", empId, homeLoanInterest, lifeInsuranceInvestment, mutualFundInvestment);
			System.out.println(rowsUpdatedInUserTable);


			dbSaveStatus = "success";

		} catch (Exception e) {
			System.err.println(e);
			dbSaveStatus = "error";
		}

		return dbSaveStatus;
	}
}
