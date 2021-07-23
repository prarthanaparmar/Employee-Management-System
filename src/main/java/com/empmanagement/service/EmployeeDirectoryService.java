package com.empmanagement.service;

import java.util.List;

import com.empmanagement.dao.IEmployeeInfoDAO;
import com.empmanagement.domain.EmployeeInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDirectoryService implements IEmployeeDirectoryService {

	@Autowired
	IEmployeeInfoDAO employeeInfoDAO;

	private Logger logger = LoggerFactory.getLogger(EmployeeDirectoryService.class);

	public List<String> getAllRoles() {
		return employeeInfoDAO.getAllRoles();
	}

	public List<String> getAllDepts() {
		return employeeInfoDAO.getAllDept();
	}

	public List<EmployeeInfo> getEmployeeInfos(String name, String role, String dept) {
		return employeeInfoDAO.getEmployeeInfos(name, role, dept);
	}
	
	public String getEmployeeRole(Long empId) {
		return employeeInfoDAO.getEmployeeRole(empId);
	}

}
