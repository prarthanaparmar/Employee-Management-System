package com.empmanagement.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * */
@DisplayName("Test suite for TimeSheetDetail class")
public class TimeSheetDetailTest {
    private String empId="",date="",day="",start_time="",end_time="";
    private String hours_worked="0";

    @DisplayName("Getter and setter test for empId1 variable")
    @Test
    public void getSetEmpIdTest(){
        TimeSheetDetail timeSheetDetail=new TimeSheetDetail();
        timeSheetDetail.setEmpId("100060");
        assertEquals("100060", timeSheetDetail.getEmpId(), "getEmpId or setEmpId is not able to get or set the correct value.");
    }

    @DisplayName("Getter and setter test for date variable")
    @Test
    public void getSetDateTest(){
        TimeSheetDetail timeSheetDetail=new TimeSheetDetail();
        timeSheetDetail.setDate("10/01/21");
        assertEquals("10/01/21", timeSheetDetail.getDate(), "getDate or setDate is not able to get or set the correct value.");
    }

    @DisplayName("Getter and setter test for day variable")
    @Test
    public void getSetDayTest(){
        TimeSheetDetail timeSheetDetail=new TimeSheetDetail();
        timeSheetDetail.setDay("Monday");
        assertEquals("Monday", timeSheetDetail.getDay(), "getDay or setDay is not able to get or set the correct value.");
    }
    @DisplayName("Getter and setter test for start_time variable")
    @Test
    public void getSetStartTimeTest(){
        TimeSheetDetail timeSheetDetail=new TimeSheetDetail();
        timeSheetDetail.setStart_time("09:00:00");
        assertEquals("09:00:00", timeSheetDetail.getStart_time(), "getStart_time or setStart_time is not able to get or set the correct value.");
    }
    @DisplayName("Getter and setter test for end_time variable")
    @Test
    public void getSetEndTimeTest(){
        TimeSheetDetail timeSheetDetail=new TimeSheetDetail();
        timeSheetDetail.setEnd_time("13:30:00");
        assertEquals("13:30:00", timeSheetDetail.getEnd_time(), "getEnd_time or setEnd_time is not able to get or set the correct value.");
    }
    @DisplayName("Getter and setter test for hours_worked variable")
    @Test
    public void getSetHoursWorked(){
        TimeSheetDetail timeSheetDetail=new TimeSheetDetail();
        timeSheetDetail.setHours_worked("10d:0h:0m");
        assertEquals("10d:0h:0m", timeSheetDetail.getHours_worked(), "getHours_worked or setHours_worked is not able to get or set the correct value.");
    }


}
