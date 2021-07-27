package com.empmanagement.service;

import com.empmanagement.domain.EmployeeReviewForm;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This interface will be responsible for implementing business logic related to reviews.
 * */
public interface ICheckReviews {
    /* Method to check the correct input received from user.*/
    public boolean checkInput(EmployeeReviewForm managerReviewForm);
    /* Method to check the input from user is double value between 0 to 10.*/
    public boolean checkGeneralInput(EmployeeReviewForm managerReviewForm);
    /* Method to save the review for an employee. */
    public String saveReview(String empId1,EmployeeReviewForm managerReviewForm);
}
