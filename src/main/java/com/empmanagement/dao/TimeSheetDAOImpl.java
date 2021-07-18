package com.empmanagement.dao;

import com.empmanagement.domain.EmployeeDetail;
import com.empmanagement.domain.TimeSheetDetail;
import com.empmanagement.domain.TimeSheetRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TimeSheetDAOImpl implements TimeSheetDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TimeSheetDetail timeSheetDetail;

    @Override
    public List<TimeSheetDetail> getTimeSheetDetail(String empId) {

        String sql="Select * from timesheet_employee t where t.empId ="+empId+ " and t.date<=localtime()";
        List<TimeSheetDetail> timeSheet= jdbcTemplate.query(sql, new TimeSheetRowMapper());
        return timeSheet;
    }

    @Override
    public List<TimeSheetDetail> getFutureTimeSheetDetail(String empId){
        String sql="Select * from timesheet_employee t where t.empId ="+empId+ " and t.date>localtime()";
        List<TimeSheetDetail> timeSheet= jdbcTemplate.query(sql, new TimeSheetRowMapper());
        return timeSheet;
    }

    @Override
    public List<TimeSheetDetail> getCurrentMonthDetail(String empId) {
        String sql="Select * from timesheet_employee t where t.empId = ? AND month(t.date)=Month(localtime()) AND year(t.date)=year(localtime())"+ " and t.date<=localtime()";
        List<TimeSheetDetail> timeSheet= jdbcTemplate.query(sql,new Object[] {empId}, new TimeSheetRowMapper());
        return timeSheet;
    }

    @Override
    public List<TimeSheetDetail> getCurrentWeekDetail(String empId) {

        String sql="Select * from timesheet_employee t where t.empId = ? AND week(t.date)=week(localtime()) AND year(t.date)=year(localtime())"+ " and t.date<=localtime()";
        List<TimeSheetDetail> timeSheet= jdbcTemplate.query(sql,new Object[] {empId}, new TimeSheetRowMapper());
        return timeSheet;
    }
}
