package com.empmanagement.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * */
@DisplayName("Test suites for EmployeeReviewForm")
public class EmployeeReviewFormTest {

    @DisplayName("Getter and setter test for peers variable")
    @Test
    public void getSetPeersTest(){
        EmployeeReviewForm employeeReviewForm=new EmployeeReviewForm();
        employeeReviewForm.setPeers("Dhruv");
        assertEquals("Dhruv", employeeReviewForm.getPeers(), "getPeers or setPeers is not able to get or set the correct value.");
    }

    @DisplayName("Getter and setter test for skillsScore variable")
    @Test
    public void getSetSkillsScoreTest(){
        EmployeeReviewForm employeeReviewForm=new EmployeeReviewForm();
        employeeReviewForm.setSkillsScore("5.5");
        assertEquals("5.5", employeeReviewForm.getSkillsScore(), "getSkillsScore or setSkillsScore is not able to get or set the correct value.");
    }

    @DisplayName("Getter and setter test for communicationScore variable")
    @Test
    public void getSetCommunicationScoreTest(){
        EmployeeReviewForm employeeReviewForm=new EmployeeReviewForm();
        employeeReviewForm.setCommunicationScore("7.5");
        assertEquals("7.5", employeeReviewForm.getCommunicationScore(), "getCommunicationScore or setCommunicationScore is not able to get or set the correct value.");
    }

    @DisplayName("Getter and setter test for leadershipScore variable")
    @Test
    public void getSetLeadershipScoreTest(){
        EmployeeReviewForm employeeReviewForm=new EmployeeReviewForm();
        employeeReviewForm.setLeadershipScore("8");
        assertEquals("8", employeeReviewForm.getLeadershipScore(), "getLeadershipScore or setLeadershipScore is not able to get or set the correct value.");
    }

    @DisplayName("Getter and setter test for peersScore variable")
    @Test
    public void getSetOthersScoreTest(){
        EmployeeReviewForm employeeReviewForm=new EmployeeReviewForm();
        employeeReviewForm.setOtherScore("6.5");
        assertEquals("6.5", employeeReviewForm.getOtherScore(), "getOtherScore or setOtherScore is not able to get or set the correct value.");
    }
}
