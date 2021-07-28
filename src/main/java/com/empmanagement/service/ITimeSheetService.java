package com.empmanagement.service;

import com.empmanagement.domain.TimeSheetDetail;
import org.springframework.stereotype.Service;
import java.util.List;

/*
* Interface for TimeSheetService
* @author: Dhruv Bharatbhai Patel (B00868931)
* */
@Service
public interface ITimeSheetService {
    /* Method to fetch the current time sheet of an employee. */
    public List<TimeSheetDetail> getTimeSheetDetails(String userId);
    /* Method to fetch scheduled time sheet of an employee*/
    public List<TimeSheetDetail> getFutureTimeSheetDetails(String userId);
    /* Method to fetch total total worked hours of an employee. */
    public String getHoursWorked(String userId);
    /*  Method to fetch total current monthly worked hours*/
    public String getCurrentMonthlyHoursDetail(String userId);
    /*  Method to fetch total current weekly worked hours*/
    public String getCurrentWeeklyHoursDetail(String userId);
}
