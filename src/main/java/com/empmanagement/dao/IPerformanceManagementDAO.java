package com.empmanagement.dao;

import com.empmanagement.domain.PerformanceManagement;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This DAO(Data access Object) interface will be responsible to perform CRUD operation related to performance management.
 * */
@Component
public interface IPerformanceManagementDAO {
    /*This method gets the list of reviews from database*/
    List<PerformanceManagement> getScores(String empId);
    /*This method gets the list of history of reviews from database*/
    List<PerformanceManagement> getReviewedReviews(String empId);
}
