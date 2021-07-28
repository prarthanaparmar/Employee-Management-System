package com.empmanagement.service;

import com.empmanagement.dao.IPeerReviewDAO;
import com.empmanagement.dao.IPerformanceManagementDAO;
import com.empmanagement.domain.EmployeePeer;
import com.empmanagement.domain.PerformanceManagement;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * */
@SpringBootTest
@AutoConfigureMockMvc
public class PerformanceManagementServiceImplTest {
    private static final String EMPLOYEE_ID1="100060";
    private static final String EMPLOYEE_ID2="100061";
    private static final String SKILLS_SCORE="5.5";
    private static final String COMMUNICATION_SCORE="8.5";
    private static final String LEADERSHIP_SCORE="7.0";
    private static final String OTHERS_SCORE="6.5";
    private static final String DATE="16/01/2021";

    private static final String EMPLOYEE_ID="100060";
    private static final String EMPLOYEE_NAME="Dhruv";

    @MockBean
    private IPerformanceManagementDAO performanceManagementDAO;
    @MockBean
    private IPeerReviewDAO peerReviewDAO;
    @Autowired
    private IPerformanceManagementService performanceManagementService;

    @Test
    public void getScoresTest(){
        PerformanceManagement performanceManagement=getPerformanceManagement();

        Map<String,Double> scores=new HashMap<>();
        scores.put("communicationScore", 85.0);
        scores.put("leadershipScore", 70.0);
        scores.put("goalsScore", 55.0);
        scores.put("otherScore", 65.0);

        when(performanceManagementDAO.getScores("100060")).thenReturn(Stream
                .of(performanceManagement).collect(Collectors.toList()));
        assertEquals(scores,performanceManagementService.getScores("100060"),"getScores method faced some issue while implementation.");
    }

    @Test
    public void checkPendingReviewsTest(){
        PerformanceManagement performanceManagement=getPerformanceManagement();
        EmployeePeer employeePeer=setPeer();

        when(performanceManagementDAO.getScores("100060")).thenReturn(Stream
                .of(performanceManagement).collect(Collectors.toList()));
        when(peerReviewDAO.getPeers("100060")).thenReturn(Stream
                .of(employeePeer).collect(Collectors.toList()));

        assertEquals(true,performanceManagementService.checkPendingReviews("100060"),"checkPendingReviews method faced some issue while implementation.");
    }

    private PerformanceManagement getPerformanceManagement(){
        PerformanceManagement performanceManagement=new PerformanceManagement();

        performanceManagement.setEmpId1(EMPLOYEE_ID1);
        performanceManagement.setEmpId2(EMPLOYEE_ID2);
        performanceManagement.setGoalsScore(SKILLS_SCORE);
        performanceManagement.setLeadershipScore(LEADERSHIP_SCORE);
        performanceManagement.setCommunicationScore(COMMUNICATION_SCORE);
        performanceManagement.setOtherScore(OTHERS_SCORE);
        performanceManagement.setDate(DATE);

        return performanceManagement;
    }

    private EmployeePeer setPeer(){
        EmployeePeer employeePeer=new EmployeePeer();
        employeePeer.setEmpId(EMPLOYEE_ID);
        employeePeer.setEmpName(EMPLOYEE_NAME);

        return employeePeer;
    }

    @After
    public void reset_mocks() {
        Mockito.reset(performanceManagementDAO);
        Mockito.reset(peerReviewDAO);
        Mockito.reset(performanceManagementService);
    }

}
