package com.empmanagement.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.empmanagement.dao.IReimbursementDao;
import com.empmanagement.domain.ReimbursementDetails;
import com.empmanagement.domain.ReimbursementRowMapper;
/**
 * This class in the data access implementation for employee reimbursement approval.
 *
 * @author Prarthanaben Parmar
 *
 */
@Repository
public class ReimbursementDaoImpl implements IReimbursementDao {
	
	private static final String QUERY_SAVE_APPLIED_REIMBURSEMENT = "INSERT INTO reimbursement(employeeId, reimbursementamount)"
			+ " VALUES (?, ?) ON DUPLICATE KEY "
			+ "UPDATE employeeId = values(employeeId), reimbursementamount = values(reimbursementamount) ";

			@Autowired
			private JdbcTemplate jdbcTemplate;
			
			private String rowsAffected;
			private int basic;
			private String status;
			private String grade;
			private String sql;

	@Override
	public List<ReimbursementDetails> getReimbursementDetails() {
		try {
			sql = "SELECT * FROM reimbursement";
			List<ReimbursementDetails> details = jdbcTemplate.query(sql, new ReimbursementRowMapper());
			return details;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getGrade(Long empID) {
		try {
			sql = "SELECT grade from employee WHERE empID = ?";
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
			sql = "SELECT basic from salary WHERE grade = ?";
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
			sql = "UPDATE reimbursement SET status = ? WHERE employeeId = ?";
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
	public String updateApprovedAllowance(Long empId, int reimburseAmount) {
		
		try {
			sql = "UPDATE employee SET redeemedMAllowance = ? WHERE empId = ?";
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
