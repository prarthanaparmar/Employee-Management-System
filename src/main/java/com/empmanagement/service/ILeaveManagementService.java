package com.empmanagement.service;

import java.util.List;

import com.empmanagement.dao.IEmployeeLeavesDAO;
import com.empmanagement.dao.LeaveBalanceDAO;
import com.empmanagement.domain.EmployeeLeave;
import com.empmanagement.domain.LeaveBalance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface ILeaveManagementService {

	public LeaveBalance getLeaveBalance(long empId);

	public List<EmployeeLeave> getEmployeeLeaves(long empId);

	public EmployeeLeave getEmployeeLeave(int employeeLeaveId);

	public boolean createOrUpdateLeaveBalance(LeaveBalance lb);

	/**
	 * This methods apply new leave. It first checks if the employee have
	 * appropriate leave balance. If the employee have sufficient leave balance, it
	 * deduct the balance and apply leave
	 * 
	 * @param employeeLeave employeeLeave
	 * @return True if employee leave is applied successfully.
	 */
	public boolean applyLeave(EmployeeLeave employeeLeave);

	/**
	 * Approves the leave applied by employee.
	 * 
	 * @param leaveId employee leave id
	 * @return returns true if updated successfully
	 */
	public boolean approveLeave(int leaveId);

	/**
	 * Cancel the applied leave. Only future leaves can be canceled.
	 * 
	 * @param leaveId employee leave id
	 * @return returns true if canceled successfully
	 */
	public boolean cancelLeave(int leaveId);

}
