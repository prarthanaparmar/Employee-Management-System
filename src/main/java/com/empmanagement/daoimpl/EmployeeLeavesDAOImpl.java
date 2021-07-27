package com.empmanagement.daoimpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.empmanagement.dao.EmployeeLeavesDAO;
import com.empmanagement.domain.EmployeeLeave;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeLeavesDAOImpl implements EmployeeLeavesDAO {

    private static final String TABLE_NAME = "employee_leaves";
    private static final String QUERY_CREATE = "INSERT INTO " + TABLE_NAME
            + " (empId, leaveType, startDt, endDt, applyDt, approveDt, cancelDt, reason) values (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String QUERY_UPDATE = "UPDATE " + TABLE_NAME
            + " SET leaveType=?, startDt=?, endDt=?, applyDt=?, approveDt=?, cancelDt=?, reason=? WHERE leaveId=?";
    private static final String QUERY_GET_BY_LEAVE_ID = "SELECT leaveId, empId, leaveType, startDt, endDt, applyDt, approveDt, cancelDt, reason FROM "
            + TABLE_NAME + " WHERE leaveId=?";
    private static final String QUERY_GET_BY_EMP_ID = "SELECT leaveId, empId, leaveType, startDt, endDt, applyDt, approveDt, cancelDt, reason FROM "
            + TABLE_NAME + " WHERE empId=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Logger logger = LoggerFactory.getLogger(EmployeeLeavesDAOImpl.class);

    @Override
    public boolean createOrUpdateLeave(EmployeeLeave employeeLeave) {
        try {
            if (employeeLeave.getLeaveId() >= 0) {
                return update(employeeLeave);
            } else {
                return create(employeeLeave);
            }
        } catch (Exception ex) {
            logger.error("Error occurred while performing create or update leave balance. ex: %s", ex);
            return false;
        }
    }

    private boolean create(EmployeeLeave employeeLeave) {
        try {
            jdbcTemplate.execute(QUERY_CREATE, new PreparedStatementCallback<Integer>() {
                @Override
                public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setLong(1, employeeLeave.getEmpId());
                    ps.setString(2, employeeLeave.getLeaveType());
                    ps.setDate(3, Date.valueOf(employeeLeave.getStartDt()));
                    ps.setDate(4, Date.valueOf(employeeLeave.getEndDt()));
                    ps.setDate(5, Date.valueOf(employeeLeave.getApplyDt()));

                    if (employeeLeave.isApproved()) {
                        ps.setDate(6, Date.valueOf(employeeLeave.getApproveDt()));
                    } else {
                        ps.setNull(6, java.sql.Types.NULL);
                        logger.debug("Leave not approved");
                    }

                    if (employeeLeave.isCanceled()) {
                        ps.setDate(7, Date.valueOf(employeeLeave.getCancelDt()));
                    } else {
                        ps.setNull(7, java.sql.Types.NULL);
                        logger.debug("Leave not canceled");
                    }

                    ps.setString(8, employeeLeave.getComment());

                    ps.execute();

                    return null;
                }
            });
            return true;
        } catch (Exception ex) {
            logger.error("Error occurred while performing create leave balance. ex: %s", ex);
            return false;
        }
    }

    private boolean update(EmployeeLeave employeeLeave) {
        try {
            jdbcTemplate.execute(QUERY_UPDATE, new PreparedStatementCallback<Integer>() {
                @Override
                public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setString(1, employeeLeave.getLeaveType());
                    ps.setDate(2, Date.valueOf(employeeLeave.getStartDt()));
                    ps.setDate(3, Date.valueOf(employeeLeave.getEndDt()));
                    ps.setDate(4, Date.valueOf(employeeLeave.getApplyDt()));

                    if (employeeLeave.isApproved()) {
                        ps.setDate(5, Date.valueOf(employeeLeave.getApproveDt()));
                    } else {
                        ps.setNull(5, java.sql.Types.NULL);
                        logger.debug("Leave not approved");
                    }

                    if (employeeLeave.isCanceled()) {
                        ps.setDate(6, Date.valueOf(employeeLeave.getCancelDt()));
                    } else {
                        ps.setNull(6, java.sql.Types.NULL);
                        logger.debug("Leave not canceled");
                    }

                    // ps.setDate(5, Date.valueOf(employeeLeave.getApproveDt()));
                    // ps.setDate(6, Date.valueOf(employeeLeave.getCancelDt()));
                    ps.setString(7, employeeLeave.getComment());
                    ps.setInt(8, employeeLeave.getLeaveId());

                    ps.execute();

                    return null;
                }
            });
            return true;
        } catch (Exception ex) {
            logger.error("Error occurred while performing update leave balance. ex: %s", ex);
            return false;
        }
    }

    @Override
    public List<EmployeeLeave> getEmployeeLeaves(long empId) {
        try {
            List<EmployeeLeave> bl = jdbcTemplate.query(QUERY_GET_BY_EMP_ID, new PreparedStatementSetter() {

                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setLong(1, empId);
                }

            }, new RowMapper<EmployeeLeave>() {

                @Override
                public EmployeeLeave mapRow(ResultSet rs, int rowNum) throws SQLException {
                    EmployeeLeave lb = new EmployeeLeave(rs.getInt(1), rs.getLong(2), rs.getString(3),
                            rs.getDate(4).toLocalDate(), rs.getDate(5).toLocalDate(), rs.getDate(6).toLocalDate(),
                            rs.getDate(7) != null ? rs.getDate(7).toLocalDate() : null,
                            rs.getDate(8) != null ? rs.getDate(8).toLocalDate() : null, rs.getString(9));
                    return lb;
                }

            });
            logger.debug("Number of Leaves found: " + bl.size());
            return bl;
        } catch (Exception ex) {
            logger.error("Error occurred while getting leaves. ex: " + ex);
            return null;
        }
    }

    @Override
    public EmployeeLeave getEmployeeLeave(int leaveId) {
        try {
            List<EmployeeLeave> bl = jdbcTemplate.query(QUERY_GET_BY_LEAVE_ID, new PreparedStatementSetter() {

                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setInt(1, leaveId);
                }

            }, new RowMapper<EmployeeLeave>() {

                @Override
                public EmployeeLeave mapRow(ResultSet rs, int rowNum) throws SQLException {
                    EmployeeLeave lb = new EmployeeLeave(rs.getInt(1), rs.getLong(2), rs.getString(3),
                            rs.getDate(4).toLocalDate(), rs.getDate(5).toLocalDate(), rs.getDate(6).toLocalDate(),
                            rs.getDate(7) != null ? rs.getDate(7).toLocalDate() : null,
                            rs.getDate(8) != null ? rs.getDate(8).toLocalDate() : null, rs.getString(9));
                    return lb;
                }

            });
            if (bl.isEmpty()) {
                // return new EmployeeLeave(leaveId);
                logger.warn("Leave not found for id: " + leaveId);
                return null;
            } else {
                logger.debug("Leave found for id: " + leaveId);
                return bl.get(0);
            }
        } catch (Exception ex) {
            logger.error("Error occurred while getting leaves. ex: " + ex);
            return null;
        }
    }

}
