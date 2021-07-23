package com.empmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.empmanagement.domain.ReimbursementDetails;
import com.empmanagement.domain.ReimbursementRowMapper;

@Repository
public class ReimbursementDaoImpl implements IReimbursementDao {

	private static final String QUERY_SAVE_APPLIED_REIMBURSEMENT = "INSERT INTO reimbursement(employeeId, reimbursementamount)"
			+ " VALUES (?, ?) ON DUPLICATE KEY "
			+ "UPDATE employeeId = values(employeeId), reimbursementamount = values(reimbursementamount) ";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ReimbursementDetails> getReimbursementDetails() {
		try {
			String sql = "SELECT * FROM reimbursement";
			List<ReimbursementDetails> details = jdbcTemplate.query(sql, new ReimbursementRowMapper());
			return details;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public String getGrade(Long empID) {
		try {
			String sql = "SELECT grade from employee WHERE empID = ?";
			String grade = jdbcTemplate.queryForObject(sql, String.class, empID);
			System.out.print("\n" + grade);
			return grade;
		} catch (Exception e) {
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
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	@Override
	public String updateReimb(Long empId, String status) {

		try {
			String sql = "UPDATE reimbursement SET status = ? WHERE employeeId = ?";
			int update = jdbcTemplate.update(sql, status, empId);
			return "success";
		} catch (Exception e) {
			System.out.print(e);
		}
		return "error";
	}

	@Override
	public String getStatus(Long empID) {

		try {
			String sql = "SELECT status from reimbursement WHERE reimbursementid = ?";
			String status = jdbcTemplate.queryForObject(sql, String.class, empID);
			return status;
		} catch (Exception e) {
			System.out.print(e);
		}
		return "error";
	}

	@Override
	public int updateApprovedAllowance(Long empId, int reimburseAmount) {

		try {
			String sql = "UPDATE employee SET redeemedMAllowance = ? WHERE empId = ?";
			int status = jdbcTemplate.update(sql, reimburseAmount, empId);
			return status;
		} catch (Exception e) {
			System.out.print(e);
		}
		return 0;
	}

	@Override
	public String updateAppliedReimbursement(Long empId, Long appliedReimbursementAmt) {
		String dbSaveStatus = null;
		try {
			int rowsUpdatedInDBTable = jdbcTemplate.update(QUERY_SAVE_APPLIED_REIMBURSEMENT, empId,
					appliedReimbursementAmt);
			if (rowsUpdatedInDBTable > 0) {
				dbSaveStatus = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			dbSaveStatus = "error";
		}
		return dbSaveStatus;
	}

}
