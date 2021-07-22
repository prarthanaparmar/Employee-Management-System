package com.empmanagement.domain;

public class EmployeeReviewForm {
    private String peers,skillsScore,communicationScore,leadershipScore,otherScore;

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
