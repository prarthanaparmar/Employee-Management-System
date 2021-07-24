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
public class TimeSheetServiceImpl implements ITimeSheetService {

    @Autowired
    private ITimeSheetDAO timeSheetDAO;

    public List<TimeSheetDetail> getTimeSheetDetails(String userId){
        List<TimeSheetDetail> tsd=timeSheetDAO.getTimeSheetDetail(userId);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        if(tsd.size()!=0) {
            for (TimeSheetDetail t : tsd) {
                try {
                    t.setHours_worked(getHours(getTimeDifference(format.parse(t.getStart_time()), format.parse(t.getEnd_time()))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return tsd;
        }
        else{
            return tsd;
        }
    }

    public List<TimeSheetDetail> getFutureTimeSheetDetails(String userId){
        List<TimeSheetDetail> tsd=timeSheetDAO.getFutureTimeSheetDetail(userId);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        if(tsd.size()!=0) {
            for (TimeSheetDetail t : tsd) {
                try {
                    t.setHours_worked(getHours(getTimeDifference(format.parse(t.getStart_time()), format.parse(t.getEnd_time()))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return tsd;
        }
        else{
            return tsd;
        }
    }

    public String getHoursWorked(String userId){
        List<TimeSheetDetail> tsd=timeSheetDAO.getTimeSheetDetail(userId);
        List<Long> hoursWorked=new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        if(tsd.size()!=0) {
            for (TimeSheetDetail t : tsd) {
                try {
                    hoursWorked.add(getTimeDifference(format.parse(t.getStart_time()), format.parse(t.getEnd_time())));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            long totalHours = getTotalHours(tsd, hoursWorked);
            return getHours(totalHours);
        }
        else{
            return "0";
        }
    }

    public String getCurrentMonthDetail(String userId){
        List<TimeSheetDetail> tsd_month=timeSheetDAO.getCurrentMonthDetail(userId);
        List<Long> hoursWorked_month=new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        if(tsd_month.size()!=0) {
            for (TimeSheetDetail t_month : tsd_month) {
                try {
                    hoursWorked_month.add(getTimeDifference(format.parse(t_month.getStart_time()), format.parse(t_month.getEnd_time())));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            long totalHours_month=getTotalHours(tsd_month,hoursWorked_month);
            return getHours(totalHours_month);
        }
        else{
            return "0";
        }

    }

    public String getCurrentWeekDetail(String userId){
        List<TimeSheetDetail> tsd_week=timeSheetDAO.getCurrentWeekDetail(userId);
        List<Long> hoursWorked_week=new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        if(tsd_week.size() !=0){
            for(TimeSheetDetail t_week:tsd_week){
                try {
                    hoursWorked_week.add(getTimeDifference(format.parse(t_week.getStart_time()),format.parse(t_week.getEnd_time())));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            long totalHours_week=getTotalHours(tsd_week,hoursWorked_week);
            return getHours(totalHours_week);
        }
        else{
            return "0";
        }
    }

    public boolean getLimit(String userId){
        List<TimeSheetDetail> tsd_week=timeSheetDAO.getCurrentWeekDetail(userId);
        List<Long> hoursWorked_week=new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        if(tsd_week.size() !=0){
            for(TimeSheetDetail t_week:tsd_week){
                try {
                    hoursWorked_week.add(getTimeDifference(format.parse(t_week.getStart_time()),format.parse(t_week.getEnd_time())));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            long totalHours_week=getTotalHours(tsd_week,hoursWorked_week);
            if(getOnlyHours(totalHours_week)>40){
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

    private long getTotalHours(List<TimeSheetDetail> tsd,List<Long> hoursWorked){
        int count=0;
        long totalHours=0;
        for(Long hours:hoursWorked){
            totalHours+=hours;
            tsd.get(count).setHours_worked((hours / (60 * 60 * 1000) % 24) +":"+(hours / (60 * 1000) % 60));
            count++;
        }
        return totalHours;
    }

    private long getOnlyHours(long milliseconds){
        final long hours = TimeUnit.MILLISECONDS.toHours(milliseconds);
        return hours;
    }

    private String getHours(long milliseconds){
        final long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds);

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
}

