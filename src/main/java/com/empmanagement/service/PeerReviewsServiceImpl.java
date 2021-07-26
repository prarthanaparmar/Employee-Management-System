package com.empmanagement.service;

import com.empmanagement.dao.IPeerReviewDAO;
import com.empmanagement.dao.IReviewsDAO;
import com.empmanagement.domain.EmployeePeer;
import com.empmanagement.domain.EmployeeReviewForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PeerReviewsServiceImpl implements IPeerReviewsService {
    @Autowired
    IPeerReviewDAO peerReviewDAO;
    @Autowired
    IReviewsDAO reviewsDAO;

    public List<EmployeePeer> getPeers(String empId){
        List<EmployeePeer> employeePeers=peerReviewDAO.getPeers(empId);
        return employeePeers;
    }
}
