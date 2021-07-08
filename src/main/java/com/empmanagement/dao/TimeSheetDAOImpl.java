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

        String sql="Select * from timesheet_employee where empId ="+empId;
        List<TimeSheetDetail> timeSheet= jdbcTemplate.query(sql, new TimeSheetRowMapper());

        for(TimeSheetDetail t:timeSheet){
            System.out.println("Date is " +t.getDate());
        }
        System.out.println("-----------------");
        return timeSheet;
    }
}
