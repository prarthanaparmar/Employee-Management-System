package com.empmanagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Prarthanaben Parmar
 *
 */

class EmployeeDetailTest {

    @Test
    void getEmpIdTest() {
        EmployeeDetail empDetail = new EmployeeDetail();
        empDetail.setEmpId("1000");
        assertEquals("1000", empDetail.getEmpId(), "get employee id or set employee id is not working properly");
    }

    @Test
    void setEmpIdTest() {
        EmployeeDetail empDetail = new EmployeeDetail();
        empDetail.setEmpId("1000");
        assertEquals("1000", empDetail.getEmpId(), "getEmpId or setEmpId is not working properly");
    }

    @Test
    void getEmpNameTest() {
        EmployeeDetail empDetail = new EmployeeDetail();
        empDetail.setEmpName("Prarthana");
        assertEquals("Prarthana", empDetail.getEmpName(), "getEmpName or setEmpName is not working properly");
    }

    @Test
    void setEmpNameTest() {
        EmployeeDetail empDetail = new EmployeeDetail();
        empDetail.setEmpName("Prarthana");
        assertEquals("Prarthana", empDetail.getEmpName(), "getEmpName or setEmpName is not working properly");
    }

    @Test
    void getUserNameTest() {
        EmployeeDetail empDetail = new EmployeeDetail();
        empDetail.setUserName("Prarthana");
        assertEquals("Prarthana", empDetail.getUserName(), "getUserName or setUserName is not working properly");
    }

    @Test
    void setUserNameTest() {
        EmployeeDetail empDetail = new EmployeeDetail();
        empDetail.setUserName("Prarthana");
        assertEquals("Prarthana", empDetail.getUserName(), "getUserName or setUserName is not working properly");
    }

    @Test
    void getPasswordTest() {
        EmployeeDetail empDetail = new EmployeeDetail();
        empDetail.setPassword("!@#$%");
        assertEquals("!@#$%", empDetail.getPassword(), "getPassword or setPassword is not working properly");
    }

    @Test
    void setPasswordTest() {
        EmployeeDetail empDetail = new EmployeeDetail();
        empDetail.setPassword("!@#$%");
        assertEquals("!@#$%", empDetail.getPassword(), "getPassword or setPassword is not working properly");
    }
}