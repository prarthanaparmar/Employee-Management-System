package com.empmanagement.service;

import org.springframework.stereotype.Service;
import java.util.Map;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This class will be responsible for implementing business logic related to performance management screen.
 * */
@Service
public interface IPerformanceManagementService {
    /* Method to fetch all the reviews for an employee; adding them to convert into percentage.*/
    public Map<String,Double> getScores(String empId);
    /* Method to check for pending mandatory manager reviews for an employee.*/
    public boolean checkPendingReviews(String empId);
}
