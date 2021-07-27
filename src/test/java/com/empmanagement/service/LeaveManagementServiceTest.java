package com.empmanagement.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.empmanagement.domain.LeaveBalance;

import org.junit.Test;

public class LeaveManagementServiceTest {
    
    @Test
    void getLeaveBalance() {
        LeaveManagementService t = new LeaveManagementService();
        assertNotNull(t.getLeaveBalance(0));
    }

    @Test
    void getEmployeeLeaves() {
        LeaveManagementService t = new LeaveManagementService();
        assertNotNull(t.getEmployeeLeaves(0));
    }

    @Test
    void getEmployeeLeave() {
        LeaveManagementService t = new LeaveManagementService();
        assertNotNull(t.getEmployeeLeave(0));
    }

    @Test
    void createOrUpdateLeaveBalance() {
        LeaveManagementService t = new LeaveManagementService();
        LeaveBalance tt = new LeaveBalance(0);
        assertTrue(t.createOrUpdateLeaveBalance(tt));
    }

}
