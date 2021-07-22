package com.empmanagement.dao;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OffBoardingDaoImpl  implements IOffBoardingDao{
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	static final String STATUS = "Disabled";

	@Override
	public Date getDateOfJoin(Long empId) {
		
		try {			
			String sql = "SELECT DOJ FROM employee WHERE empId = ?";
			Date doj = jdbcTemplate.queryForObject(sql, Date.class, empId);;		
		
		return doj;
			}
		catch (Exception e) {
			
			return null;
			}
		}

	@Override
	public int offBoardEmp(Long empId) {
		
		try {
			String sql = "DELETE FROM login WHERE empId = ? ";
			int status = jdbcTemplate.update(sql,empId);
			return status;
		}
		catch(Exception e) {
			System.out.print(e);
		}
		
		return 0;
	}

	@Override
	public int disableUser(Long empId) {
		
		try {
			String sql = "UPDATE employee set status = ? WHERE empId = ? ";
			int status = jdbcTemplate.update(sql,STATUS,empId);
			return status;
		}
		catch(Exception e) {
			System.out.print(e);
		}
		
		return 0;
	}

	@Override
	public String getEMail(Long empId) {
		
		try {
			String sql = "SELECT personalEmail FROM employee WHERE empId = ?";
			String email = jdbcTemplate.queryForObject(sql,String.class,empId);
			return email;
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return null;
	}	
}

