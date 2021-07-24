package com.empmanagement.service;

import com.empmanagement.domain.ManagerEmployeeRelation;
import com.empmanagement.domain.ManagerReviewForm;

import java.util.List;

public interface IManangerReviewsService {
    public List<ManagerEmployeeRelation> getManagers(String empId);
    public boolean checkManagerInput(ManagerReviewForm managerReviewForm);
    public boolean checkManagerGeneralInput(ManagerReviewForm managerReviewForm);
    public String saveManagerReview(String empId1,ManagerReviewForm managerReviewForm);
}
