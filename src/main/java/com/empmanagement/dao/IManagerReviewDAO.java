package com.empmanagement.dao;

import com.empmanagement.domain.EmployeePeer;

import java.util.List;

public interface IManagerReviewDAO {
    List<EmployeePeer> getManagers(String empId);
}
