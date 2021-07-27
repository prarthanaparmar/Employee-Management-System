package com.empmanagement.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

public class EmployeeDirectoryServiceTest {

    @Test
    void getAllRoles() {
        EmployeeDirectoryService t = new EmployeeDirectoryService();

        assertNotNull(t.getAllRoles());
    }

    @Test
    void getAllDepts() {
        EmployeeDirectoryService t = new EmployeeDirectoryService();

        assertNotNull(t.getAllDepts());

    }

    @Test
    void getEmployeeInfos() {
        EmployeeDirectoryService t = new EmployeeDirectoryService();

        assertNotNull(t.getEmployeeInfos("", "", ""));      
    }

    @Test
    void getEmployeeRole() {
        EmployeeDirectoryService t = new EmployeeDirectoryService();

        long i = 12345678910L;
        assertNotNull(t.getEmployeeRole(i));      
    }

    @Test
    void getEmpID() {
        EmployeeDirectoryService t = new EmployeeDirectoryService();

        assertNotNull(t.getEmpID(""));      
    }
}
