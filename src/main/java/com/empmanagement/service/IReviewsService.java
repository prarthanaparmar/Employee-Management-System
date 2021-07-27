package com.empmanagement.service;

import com.empmanagement.domain.PerformanceManagement;

import java.util.List;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This interface will be responsible for fetching data related to reviews.
 * */
public interface IReviewsService {
    /* Method to fetch the reviews from database. */
    public List<PerformanceManagement> getReviews(String empId);
}
