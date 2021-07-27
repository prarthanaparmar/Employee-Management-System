package com.empmanagement.dao;

import com.empmanagement.domain.TimeSheetDetail;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=test")
@AutoConfigureMockMvc
public class TimeSheetDAOTest {
    private static final String EMP_ID="1";
    private static final String DATE="22-07-2021";
    private static final String DAY="THURSDAY";
    private static final String START_TIME="09:00:00";
    private static final String END_TIME="20:00:00";
    private static final String HOURS_WORKED="11";
    private static final String FUTURE_DATE="22-07-2022";

    @Autowired
    private ITimeSheetDAO timeSheetDAO;


    @Test
    public void getTimeSheetDetailTest(){
//        timeSheetDAO=new TimeSheetDAOMock();
//        when(timeSheetDAO.getTimeSheetDetail("1")).thenReturn(Stream
//                .of(timeSheetDetail).collect(Collectors.toList()));
//        assertEquals(1,timeSheetDAO.getTimeSheetDetail("1").size(),"getTimeSheetDetail did not work correctly.");


        timeSheetDAO=new TimeSheetDAOImpl();
        when(timeSheetDAO.getTimeSheetDetail("100060")).thenReturn(new TimeSheetDAOMock().getFutureTimeSheetDetail("1"));

        TimeSheetDetail timeSheetDetail=setTimeSheeet();

        assertEquals(1, timeSheetDAO.getTimeSheetDetail("1").size());
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
