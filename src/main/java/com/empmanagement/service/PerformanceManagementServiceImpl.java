package com.empmanagement.service;

import com.empmanagement.dao.IManagerReviewDAO;
import com.empmanagement.dao.IPerformanceManagementDAO;
import com.empmanagement.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PerformanceManagementServiceImpl implements IPerformanceManagementService {
    @Autowired
    IPerformanceManagementDAO performanceManagementDAO;
    @Autowired
    IManagerReviewDAO managerReviewDAO;

    public Map<String,Double> getScores(String empId){
        List<PerformanceManagement> performanceManagementList=performanceManagementDAO.getScores(empId);
        Double communicationScore = 0.0,leadershipScore = 0.0,goalsScore = 0.0,otherScore = 0.0;
        Map<String,Double> scores=new HashMap<>();
        scores.put("communicationScore", (double) 0);
        scores.put("leadershipScore",(double) 0);
        scores.put("goalsScore",(double) 0);
        scores.put("otherScore",(double) 0);

        if(performanceManagementList.size()!=0){
            for(PerformanceManagement performanceManagement:performanceManagementList){
                communicationScore+= Double.parseDouble(performanceManagement.getCommunicationScore());
                leadershipScore+=Double.parseDouble(performanceManagement.getLeadershipScore());
                goalsScore+=Double.parseDouble(performanceManagement.getGoalsScore());
                otherScore+=Double.parseDouble(performanceManagement.getOtherScore());
            }
            scores.put("communicationScore",communicationScore/performanceManagementList.size()*10);
            scores.put("leadershipScore",leadershipScore/performanceManagementList.size()*10);
            scores.put("goalsScore",goalsScore/performanceManagementList.size()*10);
            scores.put("otherScore",otherScore/performanceManagementList.size()*10);

            return scores;
        }
        else{
            return scores;
        }
    }

    public boolean checkPendingReviews(String empId){
        List<EmployeePeer> managerEmployeeRelations=getManagers(empId);
        List<PerformanceManagement> performanceManagementList=performanceManagementDAO.getReviewedReviews(empId);

        for(PerformanceManagement performanceManagement:performanceManagementList){
            for(EmployeePeer managerEmployeeRelation:managerEmployeeRelations){
                if(performanceManagement.getEmpId2().equals(managerEmployeeRelation.getEmpId())){
                    return false;
                }
            }
        }
        return true;
    }

    private List<EmployeePeer> getManagers(String empId){
        List<EmployeePeer> managerEmployeeRelations=managerReviewDAO.getManagers(empId);
        return managerEmployeeRelations;
    }
}
