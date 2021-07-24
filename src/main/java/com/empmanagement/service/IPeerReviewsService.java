package com.empmanagement.service;

import com.empmanagement.domain.EmployeePeer;
import com.empmanagement.domain.EmployeeReviewForm;

import java.util.List;

public interface IPeerReviewsService {
    public List<EmployeePeer> getPeers(String empId);
    public boolean checkPeerGeneralInput(EmployeeReviewForm employeeReviewForm);
    public String savePeerReview(String empId1,EmployeeReviewForm employeeReviewForm);
    public boolean checkPeerInput(EmployeeReviewForm employeeReviewForm);
}
