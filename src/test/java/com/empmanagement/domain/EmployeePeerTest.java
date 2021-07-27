package com.empmanagement.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * */
@DisplayName("Test suite for EmployeePeer")
public class EmployeePeerTest {
    @DisplayName("Getter and Setter Test for empId")
    @Test
    public void getSetEmplIdTest(){
        EmployeePeer employeePeer=new EmployeePeer();
        employeePeer.setEmpId("1");
        assertEquals("1", employeePeer.getEmpId(), "getEmplId or setEmpId is not able to get or set the correct value.");
    }

    @DisplayName("Getter and Setter Test for empName")
    @Test
    public void getSetEmplNameTest(){
        EmployeePeer employeePeer=new EmployeePeer();
        employeePeer.setEmpName("Dhruv");
        assertEquals("Dhruv", employeePeer.getEmpName(), "getEmplName or setEmplName is not able to get the correct value.");
    }
}
