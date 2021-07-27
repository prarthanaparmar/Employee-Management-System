package com.empmanagement.dao;

import com.empmanagement.domain.TimeSheetDetail;
import java.util.ArrayList;
import java.util.List;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * */
public class TimeSheetDAOMock implements ITimeSheetDAO{
    private static final String EMP_ID="1";
    private static final String DATE="22-07-2021";
    private static final String DAY="THURSDAY";
    private static final String START_TIME="09:00:00";
    private static final String END_TIME="20:00:00";
    private static final String HOURS_WORKED="11";
    private static final String FUTURE_DATE="22-07-2022";

    @Override
    public List<TimeSheetDetail> getTimeSheetDetail(String empId) {
        List<TimeSheetDetail> timeSheetDetails=new ArrayList<>();
        if(empId.equals(EMP_ID)){
            TimeSheetDetail timeSheetDetail=setTimeSheeet();
            timeSheetDetails.add(timeSheetDetail);
        }
        return timeSheetDetails;
    }

    @Override
    public List<TimeSheetDetail> getFutureTimeSheetDetail(String empId) {
        List<TimeSheetDetail> timeSheetDetails=new ArrayList<>();
        if(empId.equals(EMP_ID)){
            TimeSheetDetail timeSheetDetail=setFutureTimeSheeet();
            timeSheetDetails.add(timeSheetDetail);
        }
        return timeSheetDetails;
    }

    @Override
    public List<TimeSheetDetail> getCurrentMonthDetail(String empId) {
        List<TimeSheetDetail> timeSheetDetails=new ArrayList<>();
        if(empId.equals(EMP_ID)){
            TimeSheetDetail timeSheetDetail=setTimeSheeet();
            timeSheetDetails.add(timeSheetDetail);
        }
        return timeSheetDetails;
    }

    @Override
    public List<TimeSheetDetail> getCurrentWeekDetail(String empId) {
        List<TimeSheetDetail> timeSheetDetails=new ArrayList<>();
        if(empId.equals(EMP_ID)){
            TimeSheetDetail timeSheetDetail=setTimeSheeet();
            timeSheetDetails.add(timeSheetDetail);
        }
        return timeSheetDetails;
    }

    private TimeSheetDetail setFutureTimeSheeet(){
        TimeSheetDetail timeSheetDetail = new TimeSheetDetail();

        timeSheetDetail.setEmpId(EMP_ID);
        timeSheetDetail.setDate(FUTURE_DATE);
        timeSheetDetail.setDay(DAY);
        timeSheetDetail.setStart_time(START_TIME);
        timeSheetDetail.setEnd_time(END_TIME);
        timeSheetDetail.setHours_worked(HOURS_WORKED);

        return timeSheetDetail;
    }

    private TimeSheetDetail setTimeSheeet(){
        TimeSheetDetail timeSheetDetail = new TimeSheetDetail();

        timeSheetDetail.setEmpId(EMP_ID);
        timeSheetDetail.setDate(DATE);
        timeSheetDetail.setDay(DAY);
        timeSheetDetail.setStart_time(START_TIME);
        timeSheetDetail.setEnd_time(END_TIME);
        timeSheetDetail.setHours_worked(HOURS_WORKED);

        return timeSheetDetail;
    }
}
