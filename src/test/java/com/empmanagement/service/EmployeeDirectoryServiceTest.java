package com.empmanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import com.empmanagement.dao.IEmployeeInfoDAO;
import com.empmanagement.daoimpl.EmployeeInfoDAOImpl;
import com.empmanagement.domain.EmployeeInfo;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * 
 * @author Neel Patel
 *
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeDirectoryServiceTest {

    @Mock
	IEmployeeInfoDAO employeeInfoDAO;

    @InjectMocks
	IEmployeeDirectoryService employeeDirectoryService;

    @Test
    void getAllRoles() {
        Mockito.when(employeeInfoDAO.getAllRoles())
		.thenReturn(new ArrayList<String>());
        
        assertNotNull(employeeDirectoryService.getAllRoles());
    }

    @Test
    void getAllDepts() {
        Mockito.when(employeeInfoDAO.getAllDept())
		.thenReturn(new ArrayList<String>());
        
        assertNotNull(employeeDirectoryService.getAllDepts());

    }

    @Test
    void getEmployeeInfos() {
        List<EmployeeInfo> employeeInfos = new ArrayList<>();

        employeeInfos.add(new EmployeeInfo(1, "test 1", "test@mail.com", "test role", "test dept"));

        Mockito.when(employeeInfoDAO.getEmployeeInfos(null, null, null))
		.thenReturn(employeeInfos);
        
        assertNotNull(employeeDirectoryService.getEmployeeInfos(null, null, null));      
        assertEquals(1, employeeDirectoryService.getEmployeeInfos(null, null, null).size());      
    }

    @Test
    void getEmployeeRole() {
        Mockito.when(employeeInfoDAO.getEmployeeRole(1L))
		.thenReturn("Test role");
        assertNotNull(employeeDirectoryService.getEmployeeRole(1L));      
        assertEquals("Test role", employeeDirectoryService.getEmployeeRole(1L));      
    }

    @Test
    void getEmpID() {
        Mockito.when(employeeInfoDAO.getEmpIDFromDatabase("test username"))
		.thenReturn(1L);
        
        assertNotNull(employeeDirectoryService.getEmpID("test username"));      
        assertEquals(1L, employeeDirectoryService.getEmpID("test username"));      
    }
}
