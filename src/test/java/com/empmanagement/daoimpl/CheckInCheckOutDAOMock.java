package com.empmanagement.daoimpl;

import com.empmanagement.dao.ICheckInCheckOutDAO;
import com.empmanagement.dao.ICheckInCheckOutDAO;
import com.empmanagement.domain.CheckInOutDetails;
import com.empmanagement.domain.CheckInOutRowMapper;
import com.empmanagement.domain.TimeSheetDetail;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckInCheckOutDAOMock implements ICheckInCheckOutDAO {


        private static final long empId=13011;
        private static final String DATE="26-07-2021";
        private static final String DAY="Monday";
        private static final String START_TIME="23:45:20";
        private static final String END_TIME="20:00:00";
        private static final String HOURS_WORKED="11";
        private static final String FUTURE_DATE="22-07-2022";

    @Override
    public void setCheckIn(Long empId) {
        List<CheckInOutDetails> checkIncheckOutDetails=new ArrayList<>();
        if(empId.equals(empId)){
            CheckInOutDetails checkincheckoutDetail=setTimeSheeet();
            checkIncheckOutDetails.add(checkincheckoutDetail);
        }
    }

    @Override
    public void updateCheckIn(Long empId) {

        List<CheckInOutDetails> checkIncheckOutDetails=new ArrayList<>();
        if(empId.equals(empId)){
            CheckInOutDetails checkincheckoutDetail=setTimeSheeet();
            checkIncheckOutDetails.add(checkincheckoutDetail);
        }

    }

    public String sayDay(Date d)
    {
        DateFormat df=new SimpleDateFormat("EEEE");
        try
        {
            return df.format(d);
        }catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public void setCheckOut(Long empId,Date date) {
        List<CheckInOutDetails> checkIncheckOutDetails=new ArrayList<>();
        if(empId.equals(empId)){
            CheckInOutDetails checkincheckoutDetail=setTimeSheeet();
            checkIncheckOutDetails.add(checkincheckoutDetail);
        }
    }

    @Override
    public List<CheckInOutDetails> getdate(Long empId)
    {

        List<CheckInOutDetails> checkIncheckOutDetails=new ArrayList<>();
        if(empId.equals(empId)){
            CheckInOutDetails checkincheckoutDetail=setTimeSheeet();
            checkIncheckOutDetails.add(checkincheckoutDetail);
        }
        return checkIncheckOutDetails;

    }

    private CheckInOutDetails setTimeSheeet() {
        CheckInOutDetails timeSheetDetail = new CheckInOutDetails();

        timeSheetDetail.setEmpId(empId);
        timeSheetDetail.setDate(DATE);
        timeSheetDetail.setDay(DAY);
        timeSheetDetail.setStart_time(START_TIME);
        timeSheetDetail.setEnd_time(END_TIME);

        return timeSheetDetail;
    }

    //@Override
    public Time getendtime(Long empId) {

        List<CheckInOutDetails> checkIncheckOutDetails=new ArrayList<>();
        if(empId.equals(empId)){
            CheckInOutDetails checkincheckoutDetail=setTimeSheeet();
            checkIncheckOutDetails.add(checkincheckoutDetail);
        }

        long p=12;
        Time t1=new Time(12);
        return t1;
    }

    @Override
    public Time getstarttime(Long empId) {

        List<CheckInOutDetails> checkIncheckOutDetails=new ArrayList<>();
        if(empId.equals(empId)){
            CheckInOutDetails checkincheckoutDetail=setTimeSheeet();
            checkIncheckOutDetails.add(checkincheckoutDetail);
        }

        long p=12;
        Time t1=new Time(12);
        return t1;
    }

    @Override
    public List<CheckInOutDetails> getTimeSheetDetail(Long empId) {

        List<CheckInOutDetails> checkIncheckOutDetails=new ArrayList<>();
        if(empId.equals(empId)){
            CheckInOutDetails checkincheckoutDetail=setTimeSheeet();
            checkIncheckOutDetails.add(checkincheckoutDetail);
        }
        return checkIncheckOutDetails;
    }







}

