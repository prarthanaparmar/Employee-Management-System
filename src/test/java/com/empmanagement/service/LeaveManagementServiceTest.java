package com.empmanagement.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import com.empmanagement.dao.LeaveBalanceDAO;
import com.empmanagement.dao.IEmployeeLeavesDAO;
import com.empmanagement.domain.EmployeeLeave;
import com.empmanagement.domain.LeaveBalance;
import com.empmanagement.serviceimpl.LeaveManagementService;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cglib.core.Local;

/**
 * 
 * @author Neel Patel
 *
 */
@ExtendWith(MockitoExtension.class)
public class LeaveManagementServiceTest {
    
    @Mock
	LeaveBalanceDAO leaveBalanceDAO;

	@Mock
    IEmployeeLeavesDAO employeeLeavesDAO;


    @InjectMocks
	ILeaveManagementService leaveManagementService;

    @Test
    void getLeaveBalance() {
        Mockito.when(leaveBalanceDAO.getLeaveBalance(1L))
        .thenReturn(new LeaveBalance(1L));

        assertNotNull(leaveManagementService.getLeaveBalance(0));
    }

    @Test
    void getEmployeeLeaves() {
        Mockito.when(employeeLeavesDAO.getEmployeeLeaves(1L))
        .thenReturn(new ArrayList<EmployeeLeave>());

        assertNotNull(leaveManagementService.getEmployeeLeaves(0));
    }

    @Test
    void getEmployeeLeave() {
        Mockito.when(employeeLeavesDAO.getEmployeeLeave(1))
        .thenReturn(new EmployeeLeave(1, 1, "PTO", LocalDate.now(), LocalDate.now(), LocalDate.now(), null, null, "Test Leave"));
        assertNotNull(leaveManagementService.getEmployeeLeave(1));
    }

    @Test
    void createOrUpdateLeaveBalance() {
        LeaveBalance tt = new LeaveBalance(0);
        
        Mockito.when(leaveBalanceDAO.createOrUpdateLeaveBalance(tt))
        .thenReturn(true);
        
        assertTrue(leaveManagementService.createOrUpdateLeaveBalance(tt));
    }

}
