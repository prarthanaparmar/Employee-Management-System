package com.empmanagement.service;

import com.empmanagement.dao.IPeerReviewDAO;
import com.empmanagement.domain.EmployeePeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This class will be responsible for implementing business logic related to peer reviews.
 * */
@Service
public class PeerReviewsServiceImpl implements IPeerReviewsService {
    @Autowired
    IPeerReviewDAO peerReviewDAO;

    /*
    * Method to fetch peers from database
    *
    * @param empId Employee ID of an employee
    * @returns List of Employee Peer
    * */
    public List<EmployeePeer> getPeers(String empId){
        return peerReviewDAO.getPeers(empId);
    }
}
