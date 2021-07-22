package com.empmanagement.domain;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TimeSheetRowMapper implements RowMapper<TimeSheetDetail> {

    @Override
    public TimeSheetDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        TimeSheetDetail timeSheetDetail=new TimeSheetDetail();

        timeSheetDetail.setDate(rs.getString("date"));
        timeSheetDetail.setDay(rs.getString("day"));
        timeSheetDetail.setStart_time(rs.getString("start_time"));
        timeSheetDetail.setEnd_time(rs.getString("end_time"));
        timeSheetDetail.setEmpId(rs.getString("empId"));

        return timeSheetDetail;

    }
}
