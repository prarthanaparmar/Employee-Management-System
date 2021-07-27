package com.empmanagement.domain;

import org.springframework.stereotype.Component;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: Model for Employee Review Form at the UI for managers and peers both.
 * */
@Component
public class EmployeeReviewForm {
    private String peers;
    private String skillsScore;
    private String communicationScore;
    private String leadershipScore;
    private String otherScore;

    public String getPeers() {
        return peers;
    }

    public void setPeers(String peers) {
        this.peers = peers;
    }

    public String getSkillsScore() {
        return skillsScore;
    }

    public void setSkillsScore(String skillsScore) {
        this.skillsScore = skillsScore;
    }

    public String getCommunicationScore() {
        return communicationScore;
    }

    public void setCommunicationScore(String communicationScore) {
        this.communicationScore = communicationScore;
    }

    public String getLeadershipScore() {
        return leadershipScore;
    }

    public void setLeadershipScore(String leadershipScore) {
        this.leadershipScore = leadershipScore;
    }

    public String getOtherScore() {
        return otherScore;
    }

    public void setOtherScore(String otherScore) {
        this.otherScore = otherScore;
    }
}
