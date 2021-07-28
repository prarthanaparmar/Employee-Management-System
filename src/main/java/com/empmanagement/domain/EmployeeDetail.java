package com.empmanagement.domain;

import org.springframework.stereotype.Component;

/**
 * @author Priti Sri Pandey
 */
@Component
public class EmployeeDetail {
    public EmployeeDetail() {
    }

    private String empName;
    private String empId;
    private String userName;
    private String password;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
