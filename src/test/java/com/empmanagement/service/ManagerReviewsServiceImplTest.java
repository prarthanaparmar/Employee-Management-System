package com.empmanagement.service;

import com.empmanagement.dao.IManagerReviewDAO;
import com.empmanagement.domain.EmployeePeer;
import org.junit.After;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * */
@DisplayName("Test suites for ManagerReviewsServiceImpl class")
@SpringBootTest
@AutoConfigureMockMvc
public class ManagerReviewsServiceImplTest {
    private static final String EMPLOYEE_ID="100060";
    private static final String EMPLOYEE_NAME="Dhruv";

    @MockBean
    IManagerReviewDAO managerReviewDAO1;
    @Autowired
    IManangerReviewsService manangerReviewsService1;

    @DisplayName("Tests for getManagers method.")
    @Test
    public void getManagersTest(){
        EmployeePeer employeePeer=setPeer();

        when(managerReviewDAO1.getManagers("100060")).thenReturn(Stream
                .of(employeePeer).collect(Collectors.toList()));
        assertEquals(1,manangerReviewsService1.getManagers("100060").size(),"getManagers method failed.");
    }

    private EmployeePeer setPeer(){
        EmployeePeer employeePeer=new EmployeePeer();
        employeePeer.setEmpId(EMPLOYEE_ID);
        employeePeer.setEmpName(EMPLOYEE_NAME);

        return employeePeer;
    }

    @After
    public void reset_mocks() {
        Mockito.reset(managerReviewDAO1);
        Mockito.reset(manangerReviewsService1);
    }

}
