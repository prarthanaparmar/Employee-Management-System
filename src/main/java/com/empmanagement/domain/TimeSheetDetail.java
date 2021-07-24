package com.empmanagement.domain;

import org.springframework.stereotype.Component;

@Component
public class TimeSheetDetail {
    public TimeSheetDetail() {
    }

    private String empId="",date="",day="",start_time="",end_time="";
    private String hours_worked="0";

    public String getHours_worked() {
        return hours_worked;}

    public void setHours_worked(String hours_worked) {
        this.hours_worked = hours_worked;
    }



    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
