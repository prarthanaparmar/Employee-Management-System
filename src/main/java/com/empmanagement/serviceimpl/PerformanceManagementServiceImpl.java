package com.empmanagement.serviceimpl;

import com.empmanagement.dao.IManagerReviewDAO;
import com.empmanagement.dao.IPerformanceManagementDAO;
import com.empmanagement.domain.*;
import com.empmanagement.service.IPerformanceManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

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
            scores.put("communicationScore", (double) 0);
            scores.put("leadershipScore",(double) 0);
            scores.put("goalsScore",(double) 0);
            scores.put("otherScore",(double) 0);

            return scores;
        }
    }

    private List<PerformanceManagement> getReviews(String empId){
        List<PerformanceManagement> performanceManagementList=performanceManagementDAO.getScores(empId);
        return performanceManagementList;
    }

    private List<ManagerEmployeeRelation> getManagers(String empId){
        List<ManagerEmployeeRelation> managerEmployeeRelations=managerReviewDAO.getManagers(empId);
        return managerEmployeeRelations;
    }
//
//    public boolean checkManagerInput(ManagerReviewForm managerReviewForm){
//        if(managerReviewForm.getManagers().length()==0){
//            return false;
//        }
//        return true;
//    }
//
//    public boolean checkManagerGeneralInput(ManagerReviewForm managerReviewForm){
//        String sScore=managerReviewForm.getSkillsScore();
//        String cScore=managerReviewForm.getCommunicationScore();
//        String lScore=managerReviewForm.getLeadershipScore();
//        String oScore=managerReviewForm.getOtherScore();
//
//        // Regex to check string
//        // contains only digits
//        String regex = "^[0-9]*\\.?[0-9]+$";
//
//        // Compile the ReGex
//        Pattern p = Pattern.compile(regex);
//
//        if(!p.matcher(cScore).matches() || !p.matcher(sScore).matches() || !p.matcher(lScore).matches() || !p.matcher(oScore).matches()){
//            return false;
//        }
//        else if(Double.parseDouble(sScore)<0 || Double.parseDouble(sScore)>10){
//            return false;
//        }
//        else if(Double.parseDouble(cScore)<0 || Double.parseDouble(cScore)>10){
//            return false;
//        }
//        else if(Double.parseDouble(lScore)<0 || Double.parseDouble(lScore)>10){
//            return false;
//        }
//        else if(Double.parseDouble(oScore)<0 || Double.parseDouble(oScore)>10){
//            return false;
//        }
//        else{
//            return true;
//        }
//
//    }
//
//    public String saveManagerReview(String empId1,ManagerReviewForm managerReviewForm){
//        String empId2=managerReviewForm.getManagers().split(" ")[0];
//        String sScore=managerReviewForm.getSkillsScore();
//        String cScore=managerReviewForm.getCommunicationScore();
//        String lScore=managerReviewForm.getLeadershipScore();
//        String oScore=managerReviewForm.getOtherScore();
//
//        Date todayDate = Calendar.getInstance().getTime();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String date = formatter.format(todayDate);
//
//        String output=performanceManagementDAO.saveReview(Integer.valueOf(empId1),Integer.valueOf(empId2),sScore,cScore,lScore,oScore,date);
//        return output;
//    }
//
//    public List<EmployeePeer> getPeers(String empId){
//        List<EmployeePeer> employeePeers=performanceManagementDAO.getPeers(empId);
//        return employeePeers;
//    }
//
//    public boolean checkPeerInput(EmployeeReviewForm employeeReviewForm){
//        if(employeeReviewForm.getPeers().length()==0){
//            return false;
//        }
//        return true;
//    }
//
//    public boolean checkPeerGeneralInput(EmployeeReviewForm employeeReviewForm){
//        String sScore=employeeReviewForm.getSkillsScore();
//        String cScore=employeeReviewForm.getCommunicationScore();
//        String lScore=employeeReviewForm.getLeadershipScore();
//        String oScore=employeeReviewForm.getOtherScore();
//
//        // Regex to check string
//        // contains only digits
//        String regex = "^[0-9]*\\.?[0-9]+$";
//
//        // Compile the ReGex
//        Pattern p = Pattern.compile(regex);
//
//        if(!p.matcher(cScore).matches() || !p.matcher(sScore).matches() || !p.matcher(lScore).matches() || !p.matcher(oScore).matches()){
//            return false;
//        }
//        else if(Double.parseDouble(sScore)<0 || Double.parseDouble(sScore)>10){
//            return false;
//        }
//        else if(Double.parseDouble(cScore)<0 || Double.parseDouble(cScore)>10){
//            return false;
//        }
//        else if(Double.parseDouble(lScore)<0 || Double.parseDouble(lScore)>10){
//            return false;
//        }
//        else if(Double.parseDouble(oScore)<0 || Double.parseDouble(oScore)>10){
//            return false;
//        }
//        else{
//            return true;
//        }
//
//    }
//
//    public String savePeerReview(String empId1,EmployeeReviewForm employeeReviewForm){
//        String empId2=employeeReviewForm.getPeers().split(" ")[0];
//        String sScore=employeeReviewForm.getSkillsScore();
//        String cScore=employeeReviewForm.getCommunicationScore();
//        String lScore=employeeReviewForm.getLeadershipScore();
//        String oScore=employeeReviewForm.getOtherScore();
//
//        Date todayDate = Calendar.getInstance().getTime();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String date = formatter.format(todayDate);
//
//        String output=performanceManagementDAO.saveReview(Integer.valueOf(empId1),Integer.valueOf(empId2),sScore,cScore,lScore,oScore,date);
//        return output;
//    }

    public boolean checkPendingReviews(String empId){
        List<ManagerEmployeeRelation> managerEmployeeRelations=getManagers(empId);
        List<PerformanceManagement> performanceManagementList=performanceManagementDAO.getReviewedReviews(empId);

        for(PerformanceManagement performanceManagement:performanceManagementList){
            for(ManagerEmployeeRelation managerEmployeeRelation:managerEmployeeRelations){
                if(performanceManagement.getEmpId2().equals(managerEmployeeRelation.getManagerId())){
                    return false;
                }
            }
        }
        return true;
    }

}
