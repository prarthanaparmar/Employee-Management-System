package com.empmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.empmanagement.domain.ReimbursementDetails;
import com.empmanagement.domain.ReimbursementRowMapper;

@Repository
public class ReimbursementDaoImpl implements IReimbursementDao {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private String rowsAffected;
    private int basic;
    private String status;
    private String grade;
    
	@Override
	public List<ReimbursementDetails> getReimbursementDetails() {
		try {			
			String sql = "SELECT * FROM reimbursement";
			List<ReimbursementDetails> details = jdbcTemplate.query(sql, new ReimbursementRowMapper());
			return details;
			}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public String getGrade(Long empID) {
		try {
			String sql = "SELECT grade from employee WHERE empID = ?";
			grade = jdbcTemplate.queryForObject(sql, String.class, empID);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return grade;	
	}

	@Override
	public int getBasicSalary(String grade) {
		try {
				
			String sql = "SELECT basic from salary WHERE grade = ?";
			basic = jdbcTemplate.queryForObject(sql, int.class, grade);
			
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		return basic;
	}

	@Override
	public String updateReimb(Long empId, String status) {
		
		try {		
			String sql = "UPDATE reimbursement SET status = ? WHERE employeeId = ?";
			int update = jdbcTemplate.update(sql,status,empId);
			if(update > 0) {
				rowsAffected =  "success";
			}
		}
		catch (Exception e) {
			rowsAffected = "error";
			e.printStackTrace();
		}
		return rowsAffected ;	
	}

	@Override
	public String getStatus(Long empID) {
		
		try {
			String sql = "SELECT status from reimbursement WHERE reimbursementid = ?";
			status = jdbcTemplate.queryForObject(sql, String.class,empID);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;	
	}

	@Override
	public String updateAllowance(Long empId, int reimburseAmount) {
		
		try {
			String sql = "UPDATE employee SET redeemedMAllowance = ? WHERE empId = ?";
			int status = jdbcTemplate.update(sql,reimburseAmount,empId);
			if(status>0) {
				rowsAffected = "success";
			}
		}
		catch (Exception e) {
			rowsAffected = "error";
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
}
