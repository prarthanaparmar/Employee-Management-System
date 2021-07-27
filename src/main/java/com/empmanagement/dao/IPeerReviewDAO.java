package com.empmanagement.dao;

import com.empmanagement.domain.EmployeePeer;

import java.util.List;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This DAO(Data access Object) interface will be responsible to perform CRUD operation related to peer reviews.
 * */
public interface IPeerReviewDAO {
    /*This method gets the list of peers from database*/
    List<EmployeePeer> getPeers(String empId);
}
