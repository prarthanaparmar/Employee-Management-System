package com.empmanagement.service;

import com.empmanagement.dao.ICheckInCheckOutDAO;
import com.empmanagement.dao.IEmployeetrainingDAO;
import com.empmanagement.domain.CheckInOutDetails;
import com.empmanagement.serviceimpl.AuthenticationServiceImpl;
import com.empmanagement.serviceimpl.EmpRegServiceImpl;
import com.empmanagement.serviceimpl.ICheckInOutServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class ICheckInOutServiceTest {

    @Mock
    private ICheckInCheckOutDAO checkInOutDAO;

    @InjectMocks
    ICheckInOutServiceImpl checkInOutService;

    private static final Long empId = (long) 13011;
    private static final String DATE="26-07-2021";
    private static final String DAY="Monday";
    private static final String START_TIME="23:45:20";
    private static final String END_TIME="20:00:00";
   // private static final String HOURS_WORKED="11";
    //private static final String FUTURE_DATE="22-07-2022";




    @Test
    void addCheckIn() {

        CheckInOutDetails checkInOutDetails=setTimeSheet();

        assertEquals(true, checkInOutService.addCheckIn(empId));
    }


    @Test
    void addCheckOut() {
        boolean b = checkInOutService.addCheckOut(empId);
        assertTrue(b);
    }

    private CheckInOutDetails setTimeSheet() {
        CheckInOutDetails timeSheetDetail = new CheckInOutDetails();

        timeSheetDetail.setEmpId(empId);
        timeSheetDetail.setDate(DATE);
        timeSheetDetail.setDay(DAY);
        timeSheetDetail.setStart_time(START_TIME);
        timeSheetDetail.setEnd_time(END_TIME);

        return timeSheetDetail;

    }
}