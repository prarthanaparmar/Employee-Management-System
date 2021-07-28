package com.empmanagement.daoimpl;

import com.empmanagement.domain.PerformanceManagement;
import com.empmanagement.domain.PerformanceManagementRowMapper;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("Test suites for PerformanceManagementDAOImpl class")
public class PerformanceManagementDAOImplTest {
    private static final String TABLE_REVIEWS="reviews";
    private static final String QUERY_GET_SCORES="Select * from "+TABLE_REVIEWS+" r where r.empId2 =";
    private static final String QUERY_GET_REVIEWED_REVIEWS="Select * from "+TABLE_REVIEWS+" r where r.empId1 =";

    private static final String EMPLOYEE_ID1="100060";
    private static final String EMPLOYEE_ID2="100061";
    private static final String SKILLS_SCORE="5.5";
    private static final String COMMUNICATION_SCORE="8.5";
    private static final String LEADERSHIP_SCORE="7.0";
    private static final String OTHERS_SCORE="6.5";
    private static final String DATE="16/01/2021";

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private PerformanceManagementDAOImpl performanceManagementDAO;

    @SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(performanceManagementDAO, "jdbcTemplate", jdbcTemplate);
    }

    @Test
    @DisplayName("Test case for getScores Test")
    public void getScoresTest(){
        PerformanceManagement performanceManagement=getPerformanceManagement();

        ReflectionTestUtils.setField(performanceManagementDAO, "jdbcTemplate", jdbcTemplate);

        Mockito.when(jdbcTemplate.query(QUERY_GET_SCORES,new PerformanceManagementRowMapper())).thenReturn(Stream
                .of(performanceManagement).collect(Collectors.toList()));

        assertEquals(0,performanceManagementDAO.getScores("100060").size());
    }

    @Test
    @DisplayName("Test suites for getReviewedReviews method")
    public void getReviewedReviewsTest(){
        PerformanceManagement performanceManagement=getPerformanceManagement();

        ReflectionTestUtils.setField(performanceManagementDAO, "jdbcTemplate", jdbcTemplate);

        Mockito.when(jdbcTemplate.query(QUERY_GET_REVIEWED_REVIEWS,new PerformanceManagementRowMapper())).thenReturn(Stream
                .of(performanceManagement).collect(Collectors.toList()));

        assertEquals(0,performanceManagementDAO.getReviewedReviews("100060").size());
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

