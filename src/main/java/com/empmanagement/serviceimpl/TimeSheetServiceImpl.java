package com.empmanagement.serviceimpl;

import com.empmanagement.dao.ITimeSheetDAO;
import com.empmanagement.domain.TimeSheetDetail;
import com.empmanagement.service.ITimeSheetOverTimeLimit;
import com.empmanagement.service.ITimeSheetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This class will be responsible for implementing business logic related to time sheet screen.
 * */
@Service
public class TimeSheetServiceImpl implements ITimeSheetService, ITimeSheetOverTimeLimit {
    private static final int OVERTIME_LIMIT=40;
    private static final int HOURS=24;
    private static final int MINUTES=60;
    private static final int MILLISECONDS_TO_SECONDS=1000;

    @Autowired
    private ITimeSheetDAO timeSheetDAO;

    /*
    * Method to fetch the current time sheet of an employee
    *
    * @param userId Employee ID af an employee
    * @returns List of time sheet model
    * */
    public List<TimeSheetDetail> getTimeSheetDetails(String userId){
        List<TimeSheetDetail> tsd=timeSheetDAO.getTimeSheetDetail(userId);

        if(tsd.size()!=0) {
            setHoursWorked(tsd);
        }
        return tsd;
    }

    /*
    * Method to fetch scheduled time sheet of an employee
    *
    * @param userID EmployeeId af an employee
    * @returns List of time sheet
    * */
    public List<TimeSheetDetail> getFutureTimeSheetDetails(String userId){
        List<TimeSheetDetail> tsd=timeSheetDAO.getFutureTimeSheetDetail(userId);

        if(tsd.size()!=0) {
            setHoursWorked(tsd);
        }
        return tsd;
    }

    /*
    * Method to fetch total current monthly worked hours
    *
    * @param userID EmployeeId af an employee
    * @returns String value of total current monthly hours
    * */
    public String getCurrentMonthlyHoursDetail(String userId){
        List<TimeSheetDetail> tsd_month=timeSheetDAO.getCurrentMonthDetail(userId);
        List<Long> hoursWorked_month;

        if(tsd_month.size()!=0) {
            hoursWorked_month=getHoursList(tsd_month);
            long totalHours_month=getTotalHours(tsd_month,hoursWorked_month);
            return getHours(totalHours_month);
        }
        else{
            return "0";
        }

    }

    /*
    * Method to fetch total current weekly worked hours
    *
    * @param userID EmployeeId af an employee
    * @returns String value of total current weekly hours
    * */
    public String getCurrentWeeklyHoursDetail(String userId){
        List<TimeSheetDetail> tsd_week=timeSheetDAO.getCurrentWeekDetail(userId);
        List<Long> hoursWorked_week;

        if(tsd_week.size() !=0){
            hoursWorked_week=getHoursList(tsd_week);
            long totalHours_week=getTotalHours(tsd_week,hoursWorked_week);
            return getHours(totalHours_week);
        }
        else{
            return "0";
        }
    }

    /*
    * Method to check if an employee has worked more than 40 hours/week
    *
    * @param userID EmployeeId af an employee
    * @returns true or false depending if employee has exceeded overtime or not
    * */
    public boolean getOvertimeLimit(String userId){
        List<TimeSheetDetail> tsd_week=timeSheetDAO.getCurrentWeekDetail(userId);
        List<Long> hoursWorked_week;

        if(tsd_week.size() !=0){
            hoursWorked_week=getHoursList(tsd_week);
            long totalHours_week=getTotalHours(tsd_week,hoursWorked_week);

            if(getOnlyHours(totalHours_week)>OVERTIME_LIMIT){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    /*
    * Method to fetch total total worked hours of an employee
    *
    * @param userID EmployeeId af an employee
    * @returns Total hours worked or 0
    * */
    public String getHoursWorked(String userId){
        List<TimeSheetDetail> tsd=timeSheetDAO.getTimeSheetDetail(userId);
        List<Long> hoursWorked;

        if(tsd.size()!=0) {
            hoursWorked=getHoursList(tsd);
            long totalHours = getTotalHours(tsd, hoursWorked);
            return getHours(totalHours);
        }
        else{
            return "0";
        }
    }

    /*
    * Method to set hours computed from start time to end time into time sheet detail model
    *
    * @param timeSheetDetail List of timeSheetDetails
    * */
    private void setHoursWorked(List<TimeSheetDetail> timeSheetDetail){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        for (TimeSheetDetail t : timeSheetDetail) {
            try {
                t.setHours_worked(getHours(getTimeDifference(format.parse(t.getStart_time()), format.parse(t.getEnd_time()))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    * Method to get the total hours from passed list of hours worked and set it to timesheet
    *
    * @param tsd List of TimeSheetDetail
    * @param hoursWorked List of hours worked by employee
    * @returns Total hours
    * */
    private long getTotalHours(List<TimeSheetDetail> tsd,List<Long> hoursWorked){
        int counter=0;
        long totalHours=0;

        for(Long hours:hoursWorked){
            totalHours+=hours;
            long days_worked=hours / (MINUTES * MINUTES * MILLISECONDS_TO_SECONDS) % HOURS;
            long hours_worked=hours / (MINUTES * MILLISECONDS_TO_SECONDS) % MINUTES;
            tsd.get(counter).setHours_worked(days_worked +":"+hours_worked);
            counter++;
        }
        return totalHours;
    }

    /*
    * Method to get the hours from milliseconds
    *
    * @param milliseconds milliseconds
    * @return hour according to millisecond
    * */
    private long getOnlyHours(long milliseconds){
        return TimeUnit.MILLISECONDS.toHours(milliseconds);
    }

    /*
    * Method to get the string in --d:--h:--m from milliseconds
    *
    * @param milliseconds milliseconds
    * @returns string in --d:--h:--m format
     * */
    private String getHours(long milliseconds){
        final long minute = TimeUnit.MILLISECONDS.toMinutes(milliseconds);
        final long hours = TimeUnit.MILLISECONDS.toHours(milliseconds);
        final long days = TimeUnit.MILLISECONDS.toDays(milliseconds);

        if(milliseconds < MILLISECONDS_TO_SECONDS){
            return (days +"d:" +hours+"h:" +minute+"m");
        }
        else{
            return (days +"d:" +hours % HOURS +"h:" +minute % MINUTES +"m");
        }
    }

    /*
    * Method to get time difference between two dates
    *
    * @param start Start date
    * @param end End date
    * @returns the time difference betwwen two dates
    * */
    private long getTimeDifference(Date start, Date end){
        return end.getTime()-start.getTime();
    }

    /*
    * Method to get the list of hours computed from the difference between start and end time.
    *
    * @param timeSheetDetails TimeSheetDetails list
    * @returns List of hours computed
    * */
    private List<Long> getHoursList(List<TimeSheetDetail> timeSheetDetails){
        List<Long> hoursWorked = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        for (TimeSheetDetail t : timeSheetDetails) {
            try {
                hoursWorked.add(getTimeDifference(format.parse(t.getStart_time()), format.parse(t.getEnd_time())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return hoursWorked;
    }
}

