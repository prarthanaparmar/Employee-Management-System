package com.empmanagement.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
/**
 *
 * @author Prarthanaben Parmar
 *
 */


public class ReimbursementRowMapper implements RowMapper<ReimbursementDetails>{
	
    @Override
    public ReimbursementDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
        ReimbursementDetails reimbursementDetails = new ReimbursementDetails();
        reimbursementDetails.setReimbursementAmount(rs.getInt("reimbursementamount"));
        reimbursementDetails.setEmployeeId(rs.getLong("employeeId"));
        reimbursementDetails.setStatus(rs.getString("status"));
        return reimbursementDetails;
    }
}
