package com.empmanagement.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckInOutRowMapper implements RowMapper<CheckInOutDetails> {

    @Override
    public CheckInOutDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        CheckInOutDetails checkInOutDetails=new CheckInOutDetails();

        checkInOutDetails.setDate(rs.getString("date"));
        checkInOutDetails.setDay(rs.getString("day"));
        checkInOutDetails.setStart_time(rs.getString("start_time"));
        checkInOutDetails.setEnd_time(rs.getString("end_time"));
        checkInOutDetails.setEmpId(rs.getLong("empId"));

        return checkInOutDetails;

    }

}
