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
 * Saves the employee investment declaration into database
 */
	public String saveInvestmentDeclaration(Long empId, Long homeLoanInterest, Long lifeInsuranceInvestment, Long mutualFundInvestment) {

		try {

			int rowsUpdatedInDBTable = jdbcTemplate.update(
					"INSERT INTO investment_declaration(empId, homeLoanInterest, lifeInsuranceInvestment, mutualFundInvestment) VALUES (?, ? ,?, ?)", empId, homeLoanInterest, lifeInsuranceInvestment, mutualFundInvestment);
			System.out.println("Successfully updated " + rowsUpdatedInDBTable);

            if(rowsUpdatedInDBTable > 0) {
			dbSaveStatus = "success";
            }

		} catch (Exception e) {
			System.err.println(e);
			dbSaveStatus = "error";
		}

		return dbSaveStatus;
	}

	@Override
	public double getBasicSalary(Long empId) {
		double basic = 0;
		try {

			basic = jdbcTemplate.queryForObject("SELECT salary.basic FROM salary INNER JOIN employee ON employee.grade = salary.grade where employee.empId = ?  ",
					Double.class, empId);

		} catch (Exception e) {

			System.err.println(e);
		}

		return basic;
	}
}
