package com.empmanagement.service;

import com.empmanagement.dao.IPeerReviewDAO;
import com.empmanagement.domain.EmployeePeer;
import org.junit.After;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.sql.SQLException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * */
@DisplayName("Test suites for PeerReviewsService class")
@SpringBootTest
@AutoConfigureMockMvc
public class PeerReviewServiceImplTest {
    private static final String EMPLOYEE_ID="100060";
    private static final String EMPLOYEE_NAME="Dhruv";

    @MockBean
    IPeerReviewDAO peerReviewDAO1;
    @Autowired
    IPeerReviewsService peerReviewsService1;

    @DisplayName("Tests for getPeers method.")
    @Test
    public void getPeersTest() throws SQLException {
        EmployeePeer employeePeer=setPeer();
        when(peerReviewDAO1.getPeers("100060")).thenReturn(Stream
                .of(employeePeer).collect(Collectors.toList()));
        assertEquals(1,peerReviewsService1.getPeers("100060").size(),"getPeers method failed.");
    }

    @After
    public void reset_mocks() {
        Mockito.reset(peerReviewsService1);
        Mockito.reset(peerReviewDAO1);
    }

    private EmployeePeer setPeer(){
        EmployeePeer employeePeer=new EmployeePeer();
        employeePeer.setEmpId(EMPLOYEE_ID);
        employeePeer.setEmpName(EMPLOYEE_NAME);

        return employeePeer;
    }
}
