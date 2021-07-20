package com.empmanagement.domain;

import org.springframework.stereotype.Component;

@Component
public class ManagerEmployeeRelation {
    private String managerId,empName;

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empId) {
        this.empName = empId;
    }
}
