package com.empmanagement.dao;

import java.util.List;

import com.empmanagement.domain.EmployeeInfo;

public interface EmployeeInfoDAO {
    
    /**
     * Return filtered list of employees
     * @param name name of the employee to be matched or null for wildcard
     * @param role employee role or null for wildcard
     * @return List<EmployeeInfo> object
     */
    public List<EmployeeInfo> getEmployeeInfos(String name, String role, String dept);
    
    /**
     * @return list of all the roles in the system
     */
    public List<String> getAllRoles();
    
    /**
     * @return list of all the dept in the system
     */
    public List<String> getAllDept();

}