package com.empmanagement.dao;

import com.empmanagement.domain.EmployeePeer;

import java.util.List;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This DAO(Data access Object) interface will be responsible to perform CRUD operation related to manager reviews.
 * */
public interface IManagerReviewDAO {
    /*This method gets the list of managers from database*/
    List<EmployeePeer> getManagers(String empId);
}
