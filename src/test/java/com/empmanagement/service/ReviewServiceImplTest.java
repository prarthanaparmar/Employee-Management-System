package com.empmanagement.service;

import com.empmanagement.dao.IPerformanceManagementDAO;
import com.empmanagement.domain.PerformanceManagement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * */
@DisplayName("Test suites for ReviewService class.")
@SpringBootTest
public class ReviewServiceImplTest {
    private static final String EMPLOYEE_ID1="100060";
    private static final String EMPLOYEE_ID2="100061";
    private static final String SKILLS_SCORE="5.5";
    private static final String COMMUNICATION_SCORE="8.5";
    private static final String LEADERSHIP_SCORE="7.0";
    private static final String OTHERS_SCORE="6.5";
    private static final String DATE="16/01/2021";

    @Autowired
    private IReviewsService reviewsService2;
    @MockBean
    private IPerformanceManagementDAO performanceManagementDAO1;

    @DisplayName("Tests for getReviews method")
    @Test
    public void getReviews(){
        PerformanceManagement performanceManagement=getPerformanceManagement();

        when(performanceManagementDAO1.getReviewedReviews("100060")).thenReturn(Stream
                .of(performanceManagement).collect(Collectors.toList()));
        assertEquals(1,reviewsService2.getReviews("100060").size(),"getScores method faced some issue while implementation.");
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

}
