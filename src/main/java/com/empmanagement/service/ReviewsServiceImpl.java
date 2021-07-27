package com.empmanagement.service;

import com.empmanagement.dao.IPerformanceManagementDAO;
import com.empmanagement.domain.PerformanceManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This class will be responsible for fetching data related to reviews.
 * */
@Service
public class ReviewsServiceImpl implements IReviewsService {

    @Autowired
    IPerformanceManagementDAO performanceManagementDAO;

    /*
    * Method to fetch the reviews from database
    *
    * @param empId Employee ID of an employee
    * @returns List of performance management
    * */
    public List<PerformanceManagement> getReviews(String empId){
        return performanceManagementDAO.getReviewedReviews(empId);
    }
}
