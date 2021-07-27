package com.empmanagement.service;

import com.empmanagement.domain.EmployeePeer;
import java.util.List;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This inteface will be responsible for implementing business logic related to manager reviews.
 * */
public interface IManangerReviewsService {
    /* Method to fetch the managers from database.*/
    public List<EmployeePeer> getManagers(String empId);
}
