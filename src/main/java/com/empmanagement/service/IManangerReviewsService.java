package com.empmanagement.service;

import com.empmanagement.domain.EmployeePeer;
import com.empmanagement.domain.EmployeeReviewForm;

import java.util.List;

public interface IManangerReviewsService {
    public List<EmployeePeer> getManagers(String empId);
}
