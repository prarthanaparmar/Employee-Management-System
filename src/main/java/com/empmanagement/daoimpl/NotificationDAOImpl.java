package com.empmanagement.daoimpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.empmanagement.dao.NotificationDAO;
import com.empmanagement.domain.Notification;

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
public class NotificationDAOImpl implements NotificationDAO {

    private static final String TABLE_NAME = "employee_notifications";
    private static final String QUERY_CREATE = "INSERT INTO " + TABLE_NAME
            + " (empId, message, createDate) values (?, ?, ?)";
    private static final String QUERY_GET_BY_NOTIFICATION_ID = "SELECT notificationId, empId, message, createDate FROM "
            + TABLE_NAME + " WHERE notificationId=?";
    private static final String QUERY_GET_BY_EMP_ID = "SELECT notificationId, empId, message, createDate FROM "
            + TABLE_NAME + " WHERE empId=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Logger logger = LoggerFactory.getLogger(EmployeeLeavesDAOImpl.class);

    @Override
    public boolean createOrUpdateNotification(Notification notification) {
        try {
            return create(notification);
        } catch (Exception ex) {
            logger.error("Error occurred while performing create or update notification. ex: %s", ex);
            return false;
        }
    }

    @Override
    public List<Notification> getNotifications(long empId) {
        try {
            List<Notification> bl = jdbcTemplate.query(QUERY_GET_BY_EMP_ID, new PreparedStatementSetter() {

                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setLong(1, empId);
                }

            }, new RowMapper<Notification>() {

                @Override
                public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Notification notification = new Notification(rs.getInt(1), rs.getLong(2), rs.getString(3),
                            rs.getDate(4).toLocalDate());
                    return notification;
                }

            });
            logger.debug("Number of notifications found: " + bl.size());
            return bl;
        } catch (Exception ex) {
            logger.error("Error occurred while getting notifications. ex: " + ex);
            return null;
        }
    }

    @Override
    public Notification getNotification(int notificationId) {
        try {
            List<Notification> bl = jdbcTemplate.query(QUERY_GET_BY_NOTIFICATION_ID, new PreparedStatementSetter() {

                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setInt(1, notificationId);
                }

            }, new RowMapper<Notification>() {

                @Override
                public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Notification lb = new Notification(rs.getInt(1), rs.getLong(2), rs.getString(3),
                            rs.getDate(4).toLocalDate());
                    return lb;
                }

            });
            if (bl.isEmpty()) {
                // return new EmployeeLeave(notificationId);
                logger.warn("Leave not found for id: " + notificationId);
                return null;
            } else {
                logger.debug("Leave found for id: " + notificationId);
                return bl.get(0);
            }
        } catch (Exception ex) {
            logger.error("Error occurred while getting notifications. ex: " + ex);
            return null;
        }
    }

    private boolean create(Notification notification) {
        try {
            jdbcTemplate.execute(QUERY_CREATE, new PreparedStatementCallback<Integer>() {
                @Override
                public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                    ps.setLong(1, notification.getEmpId());
                    ps.setString(2, notification.getMessage());
                    ps.setDate(3, Date.valueOf(notification.getCreateDate()));

                    ps.execute();

                    return null;
                }
            });
            return true;
        } catch (Exception ex) {
            logger.error("Error occurred while performing create a notification. ex: %s", ex);
            return false;
        }
    }

}
