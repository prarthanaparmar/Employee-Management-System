package com.empmanagement.service;

import com.empmanagement.dao.IReviewsDAO;
import com.empmanagement.domain.EmployeeReviewForm;
import org.junit.After;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


/*
* @author: Dhruv Bharatbhai Patel - B00868931
* */
@DisplayName("Test suites for CheckReviewsImpl class")
@SpringBootTest
@AutoConfigureMockMvc
public class CheckReviewsImplTest {
    private static final String PEERS="100060 Dhruv";
    private static final String SKILLS_SCORE="5.5";
    private static final String COMMUNICATION_SCORE="8.5";
    private static final String LEADERSHIP_SCORE="7.0";
    private static final String OTHERS_SCORE="6.5";

    @MockBean
    private IReviewsDAO reviewsDAO;
    @Autowired
    private ICheckReviews checkReviews;

    @DisplayName("Tests for checkInput method")
    @Test
    public void checkInputTest(){
        EmployeeReviewForm employeeReviewForm=setReviewForm();
        assertEquals(true,checkReviews.checkInput(employeeReviewForm),"CheckInput method failed.");
    }

    @DisplayName("Tests for checkGeneralInput method")
    @Test
    public void checkGeeneralInputTest(){
        EmployeeReviewForm employeeReviewForm=setReviewForm();
        assertEquals(true,checkReviews.checkGeneralInput(employeeReviewForm),"CheckGeneralInput method failed.");
    }

    @DisplayName("Tests for saveReview method")
    @Test
    public void saveReviewTest(){
        EmployeeReviewForm employeeReviewForm=setReviewForm();
        Date todayDate = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(todayDate);
        when(reviewsDAO.saveReview(1,100060,SKILLS_SCORE,COMMUNICATION_SCORE,LEADERSHIP_SCORE,OTHERS_SCORE,date)).thenReturn("success");
        assertEquals("success",checkReviews.saveReview("1",employeeReviewForm),"saveReview method failed.");
    }

    private EmployeeReviewForm setReviewForm(){
        EmployeeReviewForm employeeReviewForm=new EmployeeReviewForm();

        employeeReviewForm.setPeers(PEERS);
        employeeReviewForm.setSkillsScore(SKILLS_SCORE);
        employeeReviewForm.setCommunicationScore(COMMUNICATION_SCORE);
        employeeReviewForm.setLeadershipScore(LEADERSHIP_SCORE);
        employeeReviewForm.setOtherScore(OTHERS_SCORE);

        return employeeReviewForm;
    }

    @After
    public void reset_mocks() {
        Mockito.reset(reviewsDAO);
        Mockito.reset(checkReviews);
    }

}
