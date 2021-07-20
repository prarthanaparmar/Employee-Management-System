
package com.empmanagement.domain;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PerformanceManagementRowMapper implements RowMapper<PerformanceManagement> {

    @Override
    public PerformanceManagement mapRow(ResultSet rs, int rowNum) throws SQLException {
        PerformanceManagement performanceManagement=new PerformanceManagement();

        performanceManagement.setEmpId1(rs.getString("empId1"));
        performanceManagement.setEmpId2(rs.getString("empId2"));
        performanceManagement.setDate(rs.getString("date"));
        performanceManagement.setCommunicationScore(rs.getString("communicationScore"));
        performanceManagement.setGoalsScore(rs.getString("goalsScore"));
        performanceManagement.setLeadershipScore(rs.getString("leadershipScore"));
        performanceManagement.setOtherScore(rs.getString("otherScore"));

        return performanceManagement;
    }
}
