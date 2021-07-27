package com.empmanagement.service;

import com.empmanagement.domain.EmployeeReviewForm;

public interface ICheckReviews {
    public boolean checkInput(EmployeeReviewForm managerReviewForm);
    public boolean checkGeneralInput(EmployeeReviewForm managerReviewForm);
    public String saveReview(String empId1,EmployeeReviewForm managerReviewForm);
}
