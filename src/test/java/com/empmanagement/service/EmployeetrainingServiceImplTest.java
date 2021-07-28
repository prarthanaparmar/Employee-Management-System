package com.empmanagement.service;

import com.empmanagement.dao.ICheckInCheckOutDAO;
import com.empmanagement.dao.IEmployeetrainingDAO;
import com.empmanagement.domain.CheckInOutDetails;
import com.empmanagement.domain.EmployeetrainingDetails;
import com.empmanagement.serviceimpl.EmployeetrainingServiceImpl;
import com.empmanagement.serviceimpl.ICheckInOutServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class IEmployeetrainingServiceTest {

    @Mock
    private IEmployeetrainingDAO employeetrainingDAO;

    @InjectMocks
    EmployeetrainingServiceImpl employeetrainingService;

    private static final Long empId = (long) 13011;
    private static final String COURSE_NAME="Beginning Excel";
    private static final String COURSE_ID="b005";
    private static final String COURSE_TYPE="mandatory";
    private static final String CERTIFICATION="yes";

    @Test
    void TestgetTrainingDetails()
    {
        EmployeetrainingDetails employeetrainingDetails=setTrainings();
        assertEquals(0, employeetrainingService.getTrainingDetails(empId).size());
    }

    @Test
    void getMandatoryTraining() {
        EmployeetrainingDetails employeetrainingDetails=setTrainings();
        assertEquals(null, employeetrainingService.getMandatoryTraining(empId));

    }

    @Test
    void search() {
        EmployeetrainingDetails employeetrainingDetails=setTrainings();
        assertEquals(0, employeetrainingService.search("Word").size());

    }

    private EmployeetrainingDetails setTrainings() {
        EmployeetrainingDetails employeetrainingDetail = new EmployeetrainingDetails();

        employeetrainingDetail.setCoursename(COURSE_NAME);
        employeetrainingDetail.setCourseId(COURSE_ID);
        employeetrainingDetail.setCoursetype(COURSE_TYPE);
        employeetrainingDetail.setCertification(CERTIFICATION);


        return employeetrainingDetail;

    }
}