package com.empmanagement.daoimpl;

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
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("Test suites for PerformanceManagementDAOImpl class")
    public class ReviewsDAOImplTest {
    private static final String TABLE_REVIEWS="reviews";
    private static final String QUERY_SAVE_REVIEWS="INSERT INTO "+TABLE_REVIEWS+" VALUES (?, ? ,?, ?, ?, ?, ?)";

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
    private ReviewsDAOImpl reviewsDAO;

    @SuppressWarnings("deprecation")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(reviewsDAO, "jdbcTemplate", jdbcTemplate);
    }

    @Test
    @DisplayName("Test case for saveReview method")
    public void saveReviewTest(){
        ReflectionTestUtils.setField(reviewsDAO, "jdbcTemplate", jdbcTemplate);

        Mockito.when(jdbcTemplate.update(QUERY_SAVE_REVIEWS,Integer.parseInt(EMPLOYEE_ID1),Integer.parseInt(EMPLOYEE_ID2),COMMUNICATION_SCORE,SKILLS_SCORE,LEADERSHIP_SCORE,OTHERS_SCORE,DATE)).thenReturn(1);

        assertEquals("success",reviewsDAO.saveReview(Integer.parseInt(EMPLOYEE_ID1),Integer.parseInt(EMPLOYEE_ID2),SKILLS_SCORE,COMMUNICATION_SCORE,LEADERSHIP_SCORE,OTHERS_SCORE,DATE));
    }
}
