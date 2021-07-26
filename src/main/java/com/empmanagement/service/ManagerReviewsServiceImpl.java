package com.empmanagement.service;

import com.empmanagement.dao.IManagerReviewDAO;
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
public class ManagerReviewsServiceImpl implements IManangerReviewsService {
    @Autowired
    IManagerReviewDAO managerReviewDAO;
    @Autowired
    IReviewsDAO reviews;

    public List<EmployeePeer> getManagers(String empId){
        List<EmployeePeer> managerEmployeeRelations=managerReviewDAO.getManagers(empId);
        return managerEmployeeRelations;
    }
}
