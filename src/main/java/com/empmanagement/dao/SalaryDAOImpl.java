package com.empmanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SalaryDAOImpl implements SalaryDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public double getBasicSalary(Long empId) {
		double basic = 0;
		try {

			basic = jdbcTemplate.queryForObject(
					"SELECT salary.basic FROM salary INNER JOIN employee ON employee.grade = salary.grade where employee.empId = ?  ",
					Double.class, empId);

		} catch (Exception e) {

			System.err.println(e);
		}

		return basic;
	}

	@Override
	public double getMonthlyAllowance(Long empId) {
		double monthlyAllowance = 0;
		try {

			monthlyAllowance = jdbcTemplate.queryForObject("SELECT redeemedMAllowance FROM employee where empId = ?  ",
					Double.class, empId);

		} catch (NullPointerException e) {
			monthlyAllowance = 0;
		} catch (Exception e) {

			System.err.println(e);
		}

		return monthlyAllowance;
	}

	@Override
	public double getShiftAllowance(Long empId) {
		double shiftAllowance = 0;
		try {

			shiftAllowance = jdbcTemplate.queryForObject("SELECT shiftAllowance FROM employee where empId = ?  ",
					Double.class, empId);

		} catch (NullPointerException e) {
			shiftAllowance = 0;
		} catch (Exception e) {

			System.err.println(e);
		}

		return shiftAllowance;
	}

}
