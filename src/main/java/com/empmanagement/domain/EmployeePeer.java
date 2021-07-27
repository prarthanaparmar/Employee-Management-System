package com.empmanagement.domain;

import org.springframework.stereotype.Component;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: Model for Employee Peers.
 * */
@Component
public class EmployeePeer {
    private String empId;
    private String empName;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
