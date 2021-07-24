package com.empmanagement.dao;

import com.empmanagement.domain.EmployeePeer;

import java.util.List;

public interface IPeerReviewDAO {
    List<EmployeePeer> getPeers(String empId);
}
