package com.empmanagement.daoimpl;

import com.empmanagement.domain.CheckInOutDetails;
import com.empmanagement.domain.CheckInOutRowMapper;
import org.junit.jupiter.api.BeforeEach;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

class CheckInCheckOutDAOImplTest {

    private static final String TABLE_TIMESHEET_EMPLOYEE="timesheet_employee";
    private static final String QUERY_GET_TIMESHEET="Select * from "+TABLE_TIMESHEET_EMPLOYEE+" t where t.empId = ? and t.date<=localtime()";
    private static final String QUERY_SET_CHECKIN="Insert into timesheet_employee(empId,date,day,start_time,end_time) values(?,?,?,?,?)";
    private static final String QUERY_UPDATE_CHECKIN="Update timesheet_employee set start_time=? where date=? && empId=?";
    private static final String QUERY_SET_CHECKOUT="Update timesheet_employee set end_time=? where empId=? && date=?";
    private static final String QUERY_GET_DATE="Select * from timesheet_employee t where t.empId =\"+empId+\" \"";
    private static final String QUERY_GET_ENDTIME="Select end_time from timesheet_employee t where t.empId =\"+empId+ \" and t.date<=localtime()";
    private static final String QUERY_GET_STARTTIME="Select Start_time from timesheet_employee t where t.empId =\"+empId+ \" and t.date<=localtime()";


    private static final long empId=13011;
    private static final String DATE="26-07-2021";
    private static final String DAY="Monday";
    private static final String START_TIME="23:45:20";
    private static final String END_TIME="20:00:00";
    private static final String HOURS_WORKED="11";
    private static final String FUTURE_DATE="22-07-2022";

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private CheckInCheckOutDAOImpl checkInCheckOutDAO;


    @SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(checkInCheckOutDAO, "jdbcTemplate", jdbcTemplate);
    }


    @Test
    void setCheckIn() {

        ReflectionTestUtils.setField(checkInCheckOutDAO, "jdbcTemplate", jdbcTemplate);
        CheckInOutDetails checkInOutDetails=setTimeSheet();

        Mockito.when(jdbcTemplate.query(QUERY_SET_CHECKIN,new Object[]{"1000"},new CheckInOutRowMapper())).thenReturn(Stream
                .of(checkInOutDetails).collect(Collectors.toList()));

        List<CheckInOutDetails> timeSheetDetails = checkInCheckOutDAO.getTimeSheetDetail(empId);
        assertEquals(0,timeSheetDetails.size());
    }

    @Test
    void updateCheckIn() {
        ReflectionTestUtils.setField(checkInCheckOutDAO, "jdbcTemplate", jdbcTemplate);
        CheckInOutDetails checkInOutDetails=setTimeSheet();

        Mockito.when(jdbcTemplate.query(QUERY_UPDATE_CHECKIN,new Object[]{"1000"},new CheckInOutRowMapper())).thenReturn(Stream
                .of(checkInOutDetails).collect(Collectors.toList()));

        List<CheckInOutDetails> timeSheetDetails = checkInCheckOutDAO.getTimeSheetDetail(empId);
        assertEquals(0,timeSheetDetails.size());
    }

    @Test
    void setCheckOut() {
        ReflectionTestUtils.setField(checkInCheckOutDAO, "jdbcTemplate", jdbcTemplate);
        CheckInOutDetails checkInOutDetails=setTimeSheet();

        Mockito.when(jdbcTemplate.query(QUERY_SET_CHECKOUT,new Object[]{"1000"},new CheckInOutRowMapper())).thenReturn(Stream
                .of(checkInOutDetails).collect(Collectors.toList()));

        List<CheckInOutDetails> timeSheetDetails = checkInCheckOutDAO.getTimeSheetDetail(empId);
        assertEquals(0,timeSheetDetails.size());
    }

    @Test
    void getdate() {
        ReflectionTestUtils.setField(checkInCheckOutDAO, "jdbcTemplate", jdbcTemplate);
        CheckInOutDetails checkInOutDetails=setTimeSheet();

        Mockito.when(jdbcTemplate.query(QUERY_GET_DATE,new Object[]{"1000"},new CheckInOutRowMapper())).thenReturn(Stream
                .of(checkInOutDetails).collect(Collectors.toList()));

        List<CheckInOutDetails> timeSheetDetails = checkInCheckOutDAO.getTimeSheetDetail(empId);
        assertEquals(0,timeSheetDetails.size());
    }

    @Test
    void getendtime() {
        ReflectionTestUtils.setField(checkInCheckOutDAO, "jdbcTemplate", jdbcTemplate);
        CheckInOutDetails checkInOutDetails=setTimeSheet();

        Mockito.when(jdbcTemplate.query(QUERY_GET_ENDTIME,new Object[]{"1000"},new CheckInOutRowMapper())).thenReturn(Stream
                .of(checkInOutDetails).collect(Collectors.toList()));

        List<CheckInOutDetails> timeSheetDetails = checkInCheckOutDAO.getTimeSheetDetail(empId);
        assertEquals(0,timeSheetDetails.size());
    }

    @Test
    void getstarttime() {
        ReflectionTestUtils.setField(checkInCheckOutDAO, "jdbcTemplate", jdbcTemplate);
        CheckInOutDetails checkInOutDetails=setTimeSheet();

        Mockito.when(jdbcTemplate.query(QUERY_GET_STARTTIME,new Object[]{"1000"},new CheckInOutRowMapper())).thenReturn(Stream
                .of(checkInOutDetails).collect(Collectors.toList()));

        List<CheckInOutDetails> timeSheetDetails = checkInCheckOutDAO.getTimeSheetDetail(empId);
        assertEquals(0,timeSheetDetails.size());
    }

    @Test
    void getTimeSheetDetail() {

        ReflectionTestUtils.setField(checkInCheckOutDAO, "jdbcTemplate", jdbcTemplate);
        CheckInOutDetails checkInOutDetails=setTimeSheet();

        Mockito.when(jdbcTemplate.query(QUERY_GET_TIMESHEET,new Object[]{"1000"},new CheckInOutRowMapper())).thenReturn(Stream
                .of(checkInOutDetails).collect(Collectors.toList()));

        List<CheckInOutDetails> timeSheetDetails = checkInCheckOutDAO.getTimeSheetDetail(empId);
        assertEquals(0,timeSheetDetails.size());


    }

    private CheckInOutDetails setTimeSheet(){
        CheckInOutDetails timeSheetDetail = new CheckInOutDetails();

        timeSheetDetail.setEmpId(empId);
        timeSheetDetail.setDate(DATE);
        timeSheetDetail.setDay(DAY);
        timeSheetDetail.setStart_time(START_TIME);
        timeSheetDetail.setEnd_time(END_TIME);

        return timeSheetDetail;
    }

}