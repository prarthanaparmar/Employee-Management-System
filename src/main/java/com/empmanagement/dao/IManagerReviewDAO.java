package com.empmanagement.dao;

import com.empmanagement.domain.ManagerEmployeeRelation;

import java.util.List;

public interface IManagerReviewDAO {
    List<ManagerEmployeeRelation> getManagers(String empId);
}
