package com.empmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Neel Patel
 */
@DisplayName("Test suites for EmployeeInfo class")
public class EmployeeInfoTest {

    @Test
    void getEmpId() {
        EmployeeInfo t = new EmployeeInfo(1, "Test Name", "e@m.c", "test role", "test dept");
        assertEquals(1, t.getEmpId());
    }

    @Test
    void getName() {
        EmployeeInfo t = new EmployeeInfo(1, "Test Name", "e@m.c", "test role", "test dept");

        assertEquals("Test Name", t.getName());
    }

    @Test
    void getEmail() {
        EmployeeInfo t = new EmployeeInfo(1, "Test Name", "e@m.c", "test role", "test dept");

        assertEquals("e@m.c", t.getEmail());
    }

    @Test
    void getRole() {
        EmployeeInfo t = new EmployeeInfo(1, "Test Name", "e@m.c", "test role", "test dept");

        assertEquals("test role", t.getRole());
    }

    @Test
    void getDept() {
        EmployeeInfo t = new EmployeeInfo(1, "Test Name", "e@m.c", "test role", "test dept");

        assertEquals("test dept", t.getDept());
    }

}
