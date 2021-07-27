package com.empmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empmanagement.domain.EmployeeInfo;

@Service
public interface IEmployeeDirectoryService {

	public List<String> getAllRoles();

	public String getEmployeeRole(Long empId);

	public List<String> getAllDepts();

	public List<EmployeeInfo> getEmployeeInfos(String name, String role, String dept);
	
	public Long getEmpID(String userName);

}
