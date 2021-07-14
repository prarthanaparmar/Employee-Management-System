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

}
