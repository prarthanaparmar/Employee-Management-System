package com.empmanagement.service;

import com.empmanagement.domain.EmployeePeer;

import java.util.List;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This interface will be responsible for implementing business logic related to peer reviews.
 * */
public interface IPeerReviewsService {
    /* Method to fetch peers from database.*/
    public List<EmployeePeer> getPeers(String empId);
}
