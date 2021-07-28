package com.empmanagement.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.empmanagement.dao.LeaveBalanceDAO;
import com.empmanagement.domain.LeaveBalance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author Neel Patel
 */
@Repository
public class LeaveBalanceDAOImpl implements LeaveBalanceDAO {

    private static final String TABLE_NAME = "employee_leave_balance";
    private static final String QUERY_CREATE_UPDATE = "REPLACE INTO " + TABLE_NAME + " (empId, pto_leaves, casual_leaves, sick_leaves) values (?, ?, ?, ?)";
    private static final String QUERY_GET = "SELECT empId, pto_leaves, casual_leaves, sick_leaves FROM " + TABLE_NAME + " WHERE empId=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Logger logger = LoggerFactory.getLogger(LeaveBalanceDAOImpl.class);

    @Override
    public boolean createOrUpdateLeaveBalance(LeaveBalance leaveBalance) {
        try{
            jdbcTemplate.execute(QUERY_CREATE_UPDATE, new PreparedStatementCallback<Integer>(){
                @Override
                public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setLong(1, leaveBalance.getEmpId());
                    ps.setInt(2, leaveBalance.getPtoLeaves());
                    ps.setInt(3, leaveBalance.getCasualLeaves());
                    ps.setInt(4, leaveBalance.getSickLeaves());
                    
                    ps.execute();

                    return null;
                }
            });
            return true;
        } catch (Exception ex){
            logger.error("Error occurred while performing create or update leave balance. ex: %s", ex);
            return false;
        }
    }

    @Override
    public LeaveBalance getLeaveBalance(long empId) {
        try{
            List<LeaveBalance> bl = jdbcTemplate.query(QUERY_GET, new PreparedStatementSetter(){

                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setLong(1, empId);
                }
                
            }, new RowMapper<LeaveBalance>(){

                @Override
                public LeaveBalance mapRow(ResultSet rs, int rowNum) throws SQLException {
                    LeaveBalance lb = new LeaveBalance(rs.getLong(1));
                    lb.setPtoLeaves(rs.getInt(2));
                    lb.setCasualLeaves(rs.getInt(3));
                    lb.setSickLeaves(rs.getInt(4));
                    return lb;
                }
                
            });
            if (bl.isEmpty()){
                return new LeaveBalance(empId);
            }else{
                return bl.get(0);
            }
        } catch (Exception ex){
            logger.error("Error occurred while performing create or update leave balance. ex: " + ex);
            return null;
        }
    }

}
