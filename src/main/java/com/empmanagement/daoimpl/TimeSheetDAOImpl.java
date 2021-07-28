package com.empmanagement.daoimpl;

import com.empmanagement.dao.ITimeSheetDAO;
import com.empmanagement.domain.TimeSheetDetail;
import com.empmanagement.domain.TimeSheetRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This DAO(Data access Object) class communicates to database to perform CRUD operation related to timesheet.
 * */
@Repository
public class TimeSheetDAOImpl implements ITimeSheetDAO {
    private static final String TABLE_TIMESHEET_EMPLOYEE="timesheet_employee";
    private static final String QUERY_GET_TIMESHEET="Select * from "+TABLE_TIMESHEET_EMPLOYEE+" t where t.empId = ? and t.date<=localtime()";
    private static final String QUERY_GET_FUTURE_TIMESHEET="Select * from "+TABLE_TIMESHEET_EMPLOYEE+" t where t.empId = ? and t.date>localtime()";
    private static final String QUERY_GET_MONTH_TIMESHEET="Select * from "+TABLE_TIMESHEET_EMPLOYEE+" t where t.empId = ? AND month(t.date)=Month(localtime()) AND year(t.date)=year(localtime()) and t.date<=localtime()";
    private static final String QUERY_GET_WEEEK_TIMESHEET="Select * from "+TABLE_TIMESHEET_EMPLOYEE+" t where t.empId = ? AND week(t.date)=week(localtime()) AND year(t.date)=year(localtime()) and t.date<=localtime()";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TimeSheetDetail timeSheetDetail;

    /*
    * This method gets the list of timesheet from database for particular employee id
    *
    * @param empId Employee ID of an employee
    * @returns List of time sheet or null
    * */
    @Override
    public List<TimeSheetDetail> getTimeSheetDetail(String empId) {
        try {
            List<TimeSheetDetail> timeSheet = jdbcTemplate.query(QUERY_GET_TIMESHEET, new Object[]{empId}, new TimeSheetRowMapper());
            return timeSheet;
        }
        catch(Exception exception){
            System.out.println("Exception occured at while fetching time sheet: "+ exception.getMessage());
            return null;
        }
    }

    /*
    * This method gets the list of future timesheet from database for particular employee id
    *
    * @param empId Employee ID of an employee
    * @returns List of time sheet detail or null
    * */
    @Override
    public List<TimeSheetDetail> getFutureTimeSheetDetail(String empId){
        try {
            List<TimeSheetDetail> timeSheet = jdbcTemplate.query(QUERY_GET_FUTURE_TIMESHEET, new Object[]{empId}, new TimeSheetRowMapper());
            return timeSheet;
        }
        catch(Exception exception){
            System.out.println("Exception occured at while fetching future time sheet: "+ exception.getMessage());
            return null;
        }
    }

    /*This method gets the list of timesheet from database for current month
    *
    * @param empId Employee ID of an employee
    * @returns List of time sheet detail or null
    * */
    @Override
    public List<TimeSheetDetail> getCurrentMonthDetail(String empId) {
        try {
            List<TimeSheetDetail> timeSheet = jdbcTemplate.query(QUERY_GET_MONTH_TIMESHEET, new Object[]{empId}, new TimeSheetRowMapper());
            return timeSheet;
        }
        catch(Exception exception){
            System.out.println("Exception occured at while fetching current month time sheet: "+ exception.getMessage());
            return null;
        }
    }

    /*This method gets the list of timesheet from database for current week
    *
    * @param empId Employee ID of an employee
    * @returns List of time sheet detail or null
    * */
    @Override
    public List<TimeSheetDetail> getCurrentWeekDetail(String empId) {
        try {
            List<TimeSheetDetail> timeSheet = jdbcTemplate.query(QUERY_GET_WEEEK_TIMESHEET, new Object[]{empId}, new TimeSheetRowMapper());
            return timeSheet;
        }
        catch(Exception exception){
            System.out.println("Exception occured at while fetching current week time sheet: "+ exception.getMessage());
            return null;
        }
    }
}
