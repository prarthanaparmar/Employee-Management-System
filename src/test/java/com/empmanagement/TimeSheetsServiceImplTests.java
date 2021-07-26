package com.empmanagement;

import com.empmanagement.dao.ITimeSheetDAO;
import com.empmanagement.domain.TimeSheetDetail;
import com.empmanagement.service.ITimeSheetOverTimeLimit;
import com.empmanagement.service.ITimeSheetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class TimeSheetsServiceImplTests {
    private static final String EMP_ID="1";
    private static final String DATE="22-07-2021";
    private static final String DAY="THURSDAY";
    private static final String START_TIME="09:00:00";
    private static final String END_TIME="20:00:00";
    private static final String HOURS_WORKED="11";
    private static final String FUTURE_DATE="22-07-2022";


    @Autowired
    private ITimeSheetService timeSheetService;
    @Autowired
    private ITimeSheetOverTimeLimit timeSheetOverTimeLimit;

    @MockBean
    private ITimeSheetDAO timeSheetDAO;

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

    @Test
    void getTimeSheetDetailsTest() {

        TimeSheetDetail timeSheetDetail=setTimeSheeet();

        when(timeSheetDAO.getTimeSheetDetail("1")).thenReturn(Stream
                .of(timeSheetDetail).collect(Collectors.toList()));
        assertEquals(1, timeSheetService.getTimeSheetDetails("1").size());
    }

    @Test
    void getFutureTimeSheetDetailsTest() {
        TimeSheetDetail timeSheetDetail=setFutureTimeSheeet();

        when(timeSheetDAO.getFutureTimeSheetDetail("1")).thenReturn(Stream
                .of(timeSheetDetail).collect(Collectors.toList()));
        assertEquals(1, timeSheetService.getFutureTimeSheetDetails("1").size());
    }

    @Test
    void getHoursWorkedTest(){
        TimeSheetDetail timeSheetDetail=setTimeSheeet();

        when(timeSheetDAO.getTimeSheetDetail("1")).thenReturn(Stream
                .of(timeSheetDetail).collect(Collectors.toList()));
        assertEquals("0d:11h:0m", timeSheetService.getHoursWorked("1"));
    }

    @Test
    void getCurrentMonthDetailTest(){
        TimeSheetDetail timeSheetDetail=setTimeSheeet();

        when(timeSheetDAO.getCurrentMonthDetail("1")).thenReturn(Stream
                .of(timeSheetDetail).collect(Collectors.toList()));
        assertEquals("0d:11h:0m", timeSheetService.getCurrentMonthlyHoursDetail("1"));
    }

    @Test
    void getCurrentWeekDetailTest(){
        TimeSheetDetail timeSheetDetail=setTimeSheeet();

        when(timeSheetDAO.getCurrentWeekDetail("1")).thenReturn(Stream
                .of(timeSheetDetail).collect(Collectors.toList()));
        assertEquals("0d:11h:0m", timeSheetService.getCurrentWeeklyHoursDetail("1"));
    }

    @Test
    void getLimitTest(){
        TimeSheetDetail timeSheetDetail=setTimeSheeet();

        when(timeSheetDAO.getCurrentWeekDetail("1")).thenReturn(Stream
                .of(timeSheetDetail).collect(Collectors.toList()));
        assertEquals(false, timeSheetOverTimeLimit.getOvertimeLimit("1"));
    }

}
