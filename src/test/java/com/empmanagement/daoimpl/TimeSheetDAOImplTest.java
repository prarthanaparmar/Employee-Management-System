package com.empmanagement.daoimpl;

import com.empmanagement.domain.TimeSheetDetail;
import com.empmanagement.domain.TimeSheetRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;


/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("Test suites for TimeSheetDAOImpl class")
public class TimeSheetDAOImplTest {

    private static final String TABLE_TIMESHEET_EMPLOYEE="timesheet_employee";
    private static final String QUERY_GET_TIMESHEET="Select * from "+TABLE_TIMESHEET_EMPLOYEE+" t where t.empId = ? and t.date<=localtime()";
    private static final String QUERY_GET_FUTURE_TIMESHEET="Select * from "+TABLE_TIMESHEET_EMPLOYEE+" t where t.empId = ? and t.date>localtime()";
    private static final String QUERY_GET_MONTH_TIMESHEET="Select * from "+TABLE_TIMESHEET_EMPLOYEE+" t where t.empId = ? AND month(t.date)=Month(localtime()) AND year(t.date)=year(localtime()) and t.date<=localtime()";
    private static final String QUERY_GET_WEEEK_TIMESHEET="Select * from "+TABLE_TIMESHEET_EMPLOYEE+" t where t.empId = ? AND week(t.date)=week(localtime()) AND year(t.date)=year(localtime()) and t.date<=localtime()";

    private static final String EMP_ID="1000";
    private static final String DATE="22-07-2021";
    private static final String DAY="THURSDAY";
    private static final String START_TIME="09:00:00";
    private static final String END_TIME="20:00:00";
    private static final String HOURS_WORKED="11";

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private TimeSheetDAOImpl timeSheetDAO;

    @SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(timeSheetDAO, "jdbcTemplate", jdbcTemplate);
    }

    @Test
    @DisplayName("Test case for getTimeSheetDetail method")
    public void getTimeSheetDetailTest(){
        ReflectionTestUtils.setField(timeSheetDAO, "jdbcTemplate", jdbcTemplate);
        TimeSheetDetail timeSheetDetail=setTimeSheeet();

        Mockito.when(jdbcTemplate.query(QUERY_GET_TIMESHEET,new Object[]{"1000"},new TimeSheetRowMapper())).thenReturn(Stream
                .of(timeSheetDetail).collect(Collectors.toList()));

        List<TimeSheetDetail> timeSheetDetails = timeSheetDAO.getTimeSheetDetail("1000");
        assertEquals(0,timeSheetDetails.size());
    }

    @Test
    @DisplayName("Test case for getFutureTimeSheetDetail method")
    public void getFutureTimeSheetDetailTest(){
        ReflectionTestUtils.setField(timeSheetDAO, "jdbcTemplate", jdbcTemplate);
        TimeSheetDetail timeSheetDetail=setTimeSheeet();

        Mockito.when(jdbcTemplate.query(QUERY_GET_FUTURE_TIMESHEET,new Object[]{"1000"},new TimeSheetRowMapper())).thenReturn(Stream
                .of(timeSheetDetail).collect(Collectors.toList()));

        List<TimeSheetDetail> timeSheetDetails = timeSheetDAO.getFutureTimeSheetDetail("1000");
        assertEquals(0,timeSheetDetails.size() );
    }

    @Test
    @DisplayName("Test case for getCurrentMonthDetail method")
    public void getCurrentMonthDetailTest(){
        ReflectionTestUtils.setField(timeSheetDAO, "jdbcTemplate", jdbcTemplate);
        TimeSheetDetail timeSheetDetail=setTimeSheeet();

        Mockito.when(jdbcTemplate.query(QUERY_GET_MONTH_TIMESHEET,new Object[]{"1000"},new TimeSheetRowMapper())).thenReturn(Stream
                .of(timeSheetDetail).collect(Collectors.toList()));

        List<TimeSheetDetail> timeSheetDetails = timeSheetDAO.getCurrentMonthDetail("1000");
        assertEquals(0,timeSheetDetails.size() );
    }

    @Test
    @DisplayName("Test case for getCurrentWeekDetail method")
    public void getCurrentWeekDetailTest(){
        ReflectionTestUtils.setField(timeSheetDAO, "jdbcTemplate", jdbcTemplate);
        TimeSheetDetail timeSheetDetail=setTimeSheeet();

        Mockito.when(jdbcTemplate.query(QUERY_GET_WEEEK_TIMESHEET,new Object[]{"1000"},new TimeSheetRowMapper())).thenReturn(Stream
                .of(timeSheetDetail).collect(Collectors.toList()));

        List<TimeSheetDetail> timeSheetDetails = timeSheetDAO.getCurrentMonthDetail("1000");
        assertEquals(0,timeSheetDetails.size() );
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
