package com.empmanagement.service;

import com.empmanagement.dao.IManagerReviewDAO;
import com.empmanagement.dao.IPerformanceManagementDAO;
import com.empmanagement.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This class will be responsible for implementing business logic related to performance management screen.
 * */
@Service
public class PerformanceManagementServiceImpl implements IPerformanceManagementService {
    private static final int CONVERT_TO_PERCENTAGE=10;

    @Autowired
    IPerformanceManagementDAO performanceManagementDAO;
    @Autowired
    IManagerReviewDAO managerReviewDAO;

    /*
    * Method to fetch all the reviews for an employee; adding them to convert into percentage.
    *
    * @param empId Employee ID of an employee
    * @returns Map containing the key as score name and value as score value
    * */
    public Map<String,Double> getScores(String empId){
        List<PerformanceManagement> performanceManagementList=performanceManagementDAO.getScores(empId);
        double communicationScore = 0.0;
        double leadershipScore = 0.0;
        double goalsScore = 0.0;
        double otherScore = 0.0;

        // Populate hash map with default values
        Map<String,Double> scores=new HashMap<>();
        scores.put("communicationScore", (double) 0);
        scores.put("leadershipScore",(double) 0);
        scores.put("goalsScore",(double) 0);
        scores.put("otherScore",(double) 0);

        if(performanceManagementList.size()!=0){
            // For loop to add the reviews from all fetched review list
            for(PerformanceManagement performanceManagement:performanceManagementList){
                communicationScore+= Double.parseDouble(performanceManagement.getCommunicationScore());
                leadershipScore+=Double.parseDouble(performanceManagement.getLeadershipScore());
                goalsScore+=Double.parseDouble(performanceManagement.getGoalsScore());
                otherScore+=Double.parseDouble(performanceManagement.getOtherScore());
            }
            // Populate map with updated percentage values
            scores.put("communicationScore",communicationScore/performanceManagementList.size()*CONVERT_TO_PERCENTAGE);
            scores.put("leadershipScore",leadershipScore/performanceManagementList.size()*CONVERT_TO_PERCENTAGE);
            scores.put("goalsScore",goalsScore/performanceManagementList.size()*CONVERT_TO_PERCENTAGE);
            scores.put("otherScore",otherScore/performanceManagementList.size()*CONVERT_TO_PERCENTAGE);

            return scores;
        }
        else{
            return scores;
        }
    }

    /*
    * Method to check for pending mandatory manager reviews for an employee.
    *
    * @param empId Employee ID of an employee
    * @returns true or false depending input provided by user
    * */
    public boolean checkPendingReviews(String empId){
        List<EmployeePeer> managerEmployeeRelations=getManagers(empId);
        List<PerformanceManagement> performanceManagementList=performanceManagementDAO.getReviewedReviews(empId);

        // For loop to check if the employee has already reviewed the manager or not
        for(PerformanceManagement performanceManagement:performanceManagementList){
            for(EmployeePeer managerEmployeeRelation:managerEmployeeRelations){
                if(performanceManagement.getEmpId2().equals(managerEmployeeRelation.getEmpId())){
                    return false;
                }
            }
        }
        return true;
    }

    /*
    * Method to get the managers from the database
    *
    * @param empId Employee ID of an employee
    * @returns List of Employee Peer
    * */
    private List<EmployeePeer> getManagers(String empId){
        return managerReviewDAO.getManagers(empId);
    }
}
