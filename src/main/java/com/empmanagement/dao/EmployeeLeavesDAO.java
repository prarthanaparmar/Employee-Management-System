package com.empmanagement.dao;

import java.util.List;

import com.empmanagement.domain.EmployeeLeave;

public interface EmployeeLeavesDAO {
    /**
     * Create or update employee leave.
     * 
     * @param employeeLeave EmployeeLeave Object
     * @return True if creation or updation is successfully executed
     */
    public boolean createOrUpdateLeave(EmployeeLeave employeeLeave);

    /**
     * Returns list of all leaves of the employee
     * 
     * @param empId employee ID
     * @return List<EmployeeLeave> object
     */
    public List<EmployeeLeave> getEmployeeLeaves(long empId);
    
    /**
     * Returns employee leave by id
     * 
     * @param leaveId leave ID
     * @return EmployeeLeave object
     */
    public EmployeeLeave getEmployeeLeave(int leaveId);
}