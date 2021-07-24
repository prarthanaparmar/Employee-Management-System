package com.empmanagement.dao;

import com.empmanagement.domain.EmployeePeer;
import com.empmanagement.domain.ManagerEmployeeRelation;
import com.empmanagement.domain.PerformanceManagement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IPerformanceManagementDAO {
    List<PerformanceManagement> getScores(String empId);
    List<PerformanceManagement> getReviewedReviews(String empId);
}
