package com.empmanagement.service;

import com.empmanagement.dao.ITimeSheetDAO;
import com.empmanagement.domain.TimeSheetDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
public class TimeSheetServiceImpl implements ITimeSheetService,ITimeSheetOverTimeLimit {
    private static final int OVERTIME_LIMIT=40;

    @Autowired
    private ITimeSheetDAO timeSheetDAO;

    public List<TimeSheetDetail> getTimeSheetDetails(String userId){
        List<TimeSheetDetail> tsd=timeSheetDAO.getTimeSheetDetail(userId);
        if(tsd.size()!=0) {
            setHoursWorked(tsd);
        }
        return tsd;
    }

    public List<TimeSheetDetail> getFutureTimeSheetDetails(String userId){
        List<TimeSheetDetail> tsd=timeSheetDAO.getFutureTimeSheetDetail(userId);
        if(tsd.size()!=0) {
            setHoursWorked(tsd);
        }
        return tsd;
    }

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

    private long getTotalHours(List<TimeSheetDetail> tsd,List<Long> hoursWorked){
        int counter=0;
        long totalHours=0;
        for(Long hours:hoursWorked){
            totalHours+=hours;
            long days_worked=hours / (60 * 60 * 1000) % 24;
            long hours_worked=hours / (60 * 1000) % 60;
            tsd.get(counter).setHours_worked(days_worked +":"+hours_worked);
            counter++;
        }
        return totalHours;
    }

    private long getOnlyHours(long milliseconds){
        return TimeUnit.MILLISECONDS.toHours(milliseconds);
    }

    private String getHours(long milliseconds){
        final long minute = TimeUnit.MILLISECONDS.toMinutes(milliseconds);
        final long hours = TimeUnit.MILLISECONDS.toHours(milliseconds);
        final long days = TimeUnit.MILLISECONDS.toDays(milliseconds);

        if(milliseconds < 1000){
            return (days +"d:" +hours+"h:" +minute+"m");
        }
        else{
            return (days +"d:" +hours % 24 +"h:" +minute % 60 +"m");
        }
    }

    private long getTimeDifference(Date start, Date end){
        return end.getTime()-start.getTime();
    }

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

