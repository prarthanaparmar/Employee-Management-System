package com.empmanagement.service;

import com.empmanagement.dao.TimeSheetDAO;
import com.empmanagement.domain.EmployeeDetail;
import com.empmanagement.domain.TimeSheetDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.LoginDAO;

import java.util.List;


@Service
public class TimeSheetService {

    @Autowired
    private TimeSheetDAO timeSheetDAO;

    public List<TimeSheetDetail> getTimeSheetDetails(String userId){
        System.out.println("At service level "+userId);
        return timeSheetDAO.getTimeSheetDetail(userId).size() != 0 ? timeSheetDAO.getTimeSheetDetail(userId) : null;
    }


}

