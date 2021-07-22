package com.empmanagement.dao;

import com.empmanagement.domain.LeaveBalance;

public interface LeaveBalanceDAO{
    /**
     * Create or update leave balance for the employee.
     * @param leaveBalance LeaveBalance Object
     * @return True if creation or updation is successfully executed
     */
    public boolean createOrUpdateLeaveBalance(LeaveBalance leaveBalance);
    
    /**
     * Get leave balance using employee ID
     * If leave balance does not exists in repository, LeaveBalance object with default values will be returned
     * @param empId employee ID
     * @return LeaveBalance object
     */
    public LeaveBalance getLeaveBalance(long empId);
}