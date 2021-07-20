package com.empmanagement.dao;

import java.util.List;

import org.attoparser.trace.MarkupTraceEvent.InnerWhiteSpaceTraceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.empmanagement.domain.ReimbursementDetails;
import com.empmanagement.domain.ReimbursementRowMapper;

@Repository
public class ReimbursementDaoImpl implements ReimbursementDao {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ReimbursementDetails reimbursementDetails;

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
	public String getGrade(int empID) {
		try {
			String sql = "SELECT grade from employee WHERE empID = ?";
			String grade = jdbcTemplate.queryForObject(sql, String.class, empID);
			System.out.print("\n" + grade);
			return grade;		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public int getBasicSalary(String grade) {
		try {
				
			String sql = "SELECT basic from salary WHERE grade = ?";
			int basic = jdbcTemplate.queryForObject(sql, int.class, grade);
			System.out.print("\n" + basic);
			return basic;
			}
		catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	@Override
	public String updateReimb(int reimbId, String status) {
		
		try {		
			String sql = "UPDATE reimbursement SET status = ? WHERE reimbursementid = ?";
			int update = jdbcTemplate.update(sql,status,reimbId);
			return "success";
			}
		catch (Exception e) {
			System.out.print(e);
		}
		return "error";	
	}

	@Override
	public String getStatus(int reimbID) {
		
		try {
			String sql = "SELECT status from reimbursement WHERE reimbursementid = ?";
			String status = jdbcTemplate.queryForObject(sql, String.class,reimbID);
			return status;
		}
		catch (Exception e) {
			System.out.print(e);
		}
		return "error";	
	}
	
}
