package com.empmanagement.serviceimpl;

import java.util.List;

import com.empmanagement.dao.IEmployeeLeavesDAO;
import com.empmanagement.dao.LeaveBalanceDAO;
import com.empmanagement.domain.EmployeeLeave;
import com.empmanagement.domain.LeaveBalance;
import com.empmanagement.service.ILeaveManagementService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Neel Patel
 */
@Service
public class LeaveManagementService implements ILeaveManagementService {

	@Autowired
	LeaveBalanceDAO leaveBalanceDAO;

	@Autowired
	IEmployeeLeavesDAO employeeLeavesDAO;

	private Logger logger = LoggerFactory.getLogger(LeaveManagementService.class);

	public LeaveBalance getLeaveBalance(long empId) {
		return leaveBalanceDAO.getLeaveBalance(empId);
	}

	public List<EmployeeLeave> getEmployeeLeaves(long empId) {
		// TODO Retrive employee leaves from employee leaves dao for given employee id
		return employeeLeavesDAO.getEmployeeLeaves(empId);
	}

	public EmployeeLeave getEmployeeLeave(int employeeLeaveId) {
		// TODO Retrive employee leave from employee leaves dao using employee leave id
		return employeeLeavesDAO.getEmployeeLeave(employeeLeaveId);
	}

	public boolean createOrUpdateLeaveBalance(LeaveBalance lb) {
		return leaveBalanceDAO.createOrUpdateLeaveBalance(lb);
	}

	/**
	 * This methods apply new leave. It first checks if the employee have
	 * appropriate leave balance. If the employee have sufficient leave balance, it
	 * deduct the balance and apply leave
	 * 
	 * @param employeeLeave employeeLeave
	 * @return True if employee leave is applied successfully.
	 */
	public boolean applyLeave(EmployeeLeave employeeLeave) {
		// TODO Check if employeeLeave object is valid
		// Check if employee have a sufficient balance and update leave balance
		LeaveBalance lb = getLeaveBalance(employeeLeave.getEmpId());
		if (EmployeeLeave.LEAVE_TYPE_PTO.equals(employeeLeave.getLeaveType())
				&& lb.getPtoLeaves() > employeeLeave.getLeaveLength()) {
			lb.setPtoLeaves(lb.getPtoLeaves() - employeeLeave.getLeaveLength());
		} else if (EmployeeLeave.LEAVE_TYPE_CASUAL.equals(employeeLeave.getLeaveType())
				&& lb.getCasualLeaves() > employeeLeave.getLeaveLength()) {
			lb.setCasualLeaves(lb.getCasualLeaves() - employeeLeave.getLeaveLength());
		} else if (EmployeeLeave.LEAVE_TYPE_SICK.equals(employeeLeave.getLeaveType())
				&& lb.getSickLeaves() > employeeLeave.getLeaveLength()) {
			lb.setSickLeaves(lb.getSickLeaves() - employeeLeave.getLeaveLength());
		} else {
			logger.warn("Invalid leave type or ", lb);
			return false;
		}
		// Store updated leave balance and employee leave in db atomically
		if (createOrUpdateLeaveBalance(lb) && employeeLeavesDAO.createOrUpdateLeave(employeeLeave)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Approves the leave applied by employee.
	 * 
	 * @param leaveId employee leave id
	 * @return returns true if updated successfully
	 */
	public boolean approveLeave(int leaveId) {
		// check if leave can be canceled
		EmployeeLeave employeeLeave = getEmployeeLeave(leaveId);
		if ((!employeeLeave.isTaken()) && (!employeeLeave.isCanceled())) {
			employeeLeave.approveLeave();

			// update database
			if (employeeLeavesDAO.createOrUpdateLeave(employeeLeave)) {
				return true;
			} else {
				return false;
			}
		} else {
			logger.warn("Leave not cancelable.");
			return false;
		}
	}

	/**
	 * Cancel the applied leave. Only future leaves can be canceled.
	 * 
	 * @param leaveId employee leave id
	 * @return returns true if canceled successfully
	 */
	public boolean cancelLeave(int leaveId) {
		// check if leave can be canceled
		EmployeeLeave employeeLeave = getEmployeeLeave(leaveId);
		if ((!employeeLeave.isTaken()) && (!employeeLeave.isCanceled())) {
			LeaveBalance lb = getLeaveBalance(employeeLeave.getEmpId());
			employeeLeave.cancelLeave();

			if (EmployeeLeave.LEAVE_TYPE_PTO.equals(employeeLeave.getLeaveType())) {
				lb.setPtoLeaves(lb.getPtoLeaves() + employeeLeave.getLeaveLength());
			} else if (EmployeeLeave.LEAVE_TYPE_CASUAL.equals(employeeLeave.getLeaveType())) {
				lb.setCasualLeaves(lb.getCasualLeaves() + employeeLeave.getLeaveLength());
			} else if (EmployeeLeave.LEAVE_TYPE_SICK.equals(employeeLeave.getLeaveType())) {
				lb.setSickLeaves(lb.getSickLeaves() + employeeLeave.getLeaveLength());
			} else {
				logger.warn("Invalid leave type");
				return false;
			}

			// update database
			if (createOrUpdateLeaveBalance(lb) && employeeLeavesDAO.createOrUpdateLeave(employeeLeave)) {
				return true;
			} else {
				return false;
			}
		} else {
			logger.warn("Leave not cancelable.");
			return false;
		}
	}

}
