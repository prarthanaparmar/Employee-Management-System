package com.empmanagement.service;

import com.empmanagement.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PerformanceManagementService {
    public Map<String,Double> getScores(String empId);
    public List<PerformanceManagement> getReviews(String empId);
    public List<ManagerEmployeeRelation> getManagers(String empId);
    public List<EmployeePeer> getPeers(String empId);
    public boolean checkManagerInput(ManagerReviewForm managerReviewForm);
    public boolean checkManagerGeneralInput(ManagerReviewForm managerReviewForm);
    public String saveManagerReview(String empId1,ManagerReviewForm managerReviewForm);
    public boolean checkPeerGeneralInput(EmployeeReviewForm employeeReviewForm);
    public String savePeerReview(String empId1,EmployeeReviewForm employeeReviewForm);
    public boolean checkPeerInput(EmployeeReviewForm employeeReviewForm);
    public boolean checkPendingReviews(String empId);
}
