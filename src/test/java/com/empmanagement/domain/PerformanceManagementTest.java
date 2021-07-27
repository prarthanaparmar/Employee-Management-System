package com.empmanagement.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * */
@DisplayName("Test suites for PerfomanceManagement class")
public class PerformanceManagementTest {

    @DisplayName("Getter and setter test for empId1 variable")
    @Test
    public void getSetEmpId1Test(){
        PerformanceManagement performanceManagement=new PerformanceManagement();
        performanceManagement.setEmpId1("100060");
        assertEquals("100060", performanceManagement.getEmpId1(), "getEmpId1 or setEmpId1 is not able to get or set the correct value.");
    }

    @DisplayName("Getter and setter test for empId2 variable")
    @Test
    public void getSetEmpId2Test(){
        PerformanceManagement performanceManagement=new PerformanceManagement();
        performanceManagement.setEmpId2("100060");
        assertEquals("100060", performanceManagement.getEmpId2(), "getEmpId2 or setEmpId2 is not able to get or set the correct value.");
    }

    @DisplayName("Getter and setter test for CommunicationScore variable")
    @Test
    public void getSetCommunicationScoreTest(){
        PerformanceManagement performanceManagement=new PerformanceManagement();
        performanceManagement.setCommunicationScore("5.5");
        assertEquals("5.5", performanceManagement.getCommunicationScore(), "getCommunicationScore or setCommunicationScore is not able to get or set the correct value.");
    }

    @DisplayName("Getter and setter test for GoalsScore variable")
    @Test
    public void getSetGoalsScoreTest(){
        PerformanceManagement performanceManagement=new PerformanceManagement();
        performanceManagement.setGoalsScore("8.5");
        assertEquals("8.5", performanceManagement.getGoalsScore(), "getGoalsScore or setGoalsScore is not able to get or set the correct value.");
    }

    @DisplayName("Getter and setter test for LeadershipScore variable")
    @Test
    public void getSetLeadershipScoreTest(){
        PerformanceManagement performanceManagement=new PerformanceManagement();
        performanceManagement.setLeadershipScore("7");
        assertEquals("7", performanceManagement.getLeadershipScore(), "getLeadershipScore or setLeadershipScore is not able to get or set the correct value.");
    }
    @DisplayName("Getter and setter test for OtherScore variable")
    @Test
    public void getSetOtherScoreTest(){
        PerformanceManagement performanceManagement=new PerformanceManagement();
        performanceManagement.setOtherScore("6.5");
        assertEquals("6.5", performanceManagement.getOtherScore(), "getOtherScore or setOtherScore is not able to get or set the correct value.");
    }
    @DisplayName("Getter and setter test for date variable")
    @Test
    public void getSetDateTest(){
        PerformanceManagement performanceManagement=new PerformanceManagement();
        performanceManagement.setDate("04/12/2021");
        assertEquals("04/12/2021", performanceManagement.getDate(), "getDate or setDate is not able to get or set the correct value.");
    }

}
