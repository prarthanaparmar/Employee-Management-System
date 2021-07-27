package com.empmanagement.service;

import com.empmanagement.dao.IManagerReviewDAO;
import com.empmanagement.domain.EmployeePeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This class will be responsible for implementing business logic related to manager reviews.
 * */
@Service
public class ManagerReviewsServiceImpl implements IManangerReviewsService {
    @Autowired
    IManagerReviewDAO managerReviewDAO;

    /*
    * Method to fetch the managers from database.
    *
    * @param empId Employee ID of an employee
    * @returns List of Employee Peer
    * */
    public List<EmployeePeer> getManagers(String empId){
        return managerReviewDAO.getManagers(empId);
    }
}
