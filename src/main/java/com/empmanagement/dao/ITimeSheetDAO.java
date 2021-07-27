package com.empmanagement.dao;

import com.empmanagement.domain.TimeSheetDetail;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This DAO(Data access Object) interface will be responsible to perform CRUD operation related to timesheet.
 * */
@Component
public interface ITimeSheetDAO {
    /*This method gets the list of timesheet from database for particular employee id*/
    List<TimeSheetDetail> getTimeSheetDetail(String empId);
    /*This method gets the list of future timesheet from database for particular employee id*/
    List<TimeSheetDetail> getFutureTimeSheetDetail(String empId);
    /*This method gets the list of timesheet from database for current month*/
    List<TimeSheetDetail> getCurrentMonthDetail(String empId);
    /*This method gets the list of timesheet from database for current week*/
    List<TimeSheetDetail> getCurrentWeekDetail(String empId);
}
