package com.empmanagement.dao;

import com.empmanagement.domain.EmployeePeer;
import com.empmanagement.domain.ManagerEmployeeRelation;
import com.empmanagement.domain.PerformanceManagement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PerformanceManagementDAO {
    List<PerformanceManagement> getScores(String empId);
    List<ManagerEmployeeRelation> getManagers(String empId);
    List<EmployeePeer> getPeers(String empId);
    public String saveReview(int empId1,int empId2,String sScore,String cScore,String lScore,String oScore,String date);
}
