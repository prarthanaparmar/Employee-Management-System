package com.empmanagement.domain;

import org.springframework.stereotype.Component;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: Model for Performance Management according to reviews table in our database.
 * */
@Component
public class PerformanceManagement {
    private String empId1;
    private String empId2;
    private String CommunicationScore;
    private String GoalsScore;
    private String LeadershipScore;
    private String OtherScore;
    private String date;

    public String getEmpId1() {
        return empId1;
    }

    public void setEmpId1(String empId1) {
        this.empId1 = empId1;
    }

    public String getEmpId2() {
        return empId2;
    }

    public void setEmpId2(String empId2) {
        this.empId2 = empId2;
    }

    public String getCommunicationScore() {
        return CommunicationScore;
    }

    public void setCommunicationScore(String communicationScore) {
        CommunicationScore = communicationScore;
    }

    public String getGoalsScore() {
        return GoalsScore;
    }

    public void setGoalsScore(String goalsScore) {
        GoalsScore = goalsScore;
    }

    public String getLeadershipScore() {
        return LeadershipScore;
    }

    public void setLeadershipScore(String leadershipScore) {
        LeadershipScore = leadershipScore;
    }

    public String getOtherScore() {
        return OtherScore;
    }

    public void setOtherScore(String otherScore) {
        OtherScore = otherScore;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
