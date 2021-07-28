package com.empmanagement.service;

import java.util.List;

import com.empmanagement.domain.EmployeeInfo;

import org.springframework.stereotype.Service;

/**
 * @author Neel Patel
 */
@Service
public interface IEmployeeDirectoryService {

	public List<String> getAllRoles();

	public String getEmployeeRole(Long empId);

	public List<String> getAllDepts();

	public List<EmployeeInfo> getEmployeeInfos(String name, String role, String dept);

	public Long getEmpID(String userName);

}
