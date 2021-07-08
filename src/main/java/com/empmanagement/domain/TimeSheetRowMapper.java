package com.empmanagement.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TimeSheetRowMapper implements RowMapper<TimeSheetDetail> {



    @Override
    public TimeSheetDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        TimeSheetDetail timeSheetDetail=new TimeSheetDetail();

        System.out.println(rs.getString("date"));
        System.out.println(rs.getString("day"));
        System.out.println(rs.getString("start_time"));
        System.out.println(rs.getString("end_time"));
        System.out.println(rs.getString("empId"));
        timeSheetDetail.setDate(rs.getString("date"));
        timeSheetDetail.setDay(rs.getString("day"));
        timeSheetDetail.setStart_time(rs.getString("start_time"));
        timeSheetDetail.setEnd_time(rs.getString("end_time"));
        timeSheetDetail.setEmpId(rs.getString("empId"));
        System.out.println("After error");

        return timeSheetDetail;

    }
}
