package com.empmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.IReimbursementDao;
import com.empmanagement.dao.ReimbursementDaoImpl;
import com.empmanagement.domain.ReimbursementDetails;

@Service
public class ReimbursementServiceImpl implements IReimbursementService {

	@Autowired
	IReimbursementDao reimbursementDao = new ReimbursementDaoImpl();
	private int baseSalary;
	private String grade;
	private double reimbLimit;
	private boolean valid;
	private String status;
	private Long employeeID;
	private int reimbAmount;
	static final int REIMBDECLINE = 0;
	static final double PERC = 0.1;
	static final String APPROVED = "approved";
	static final String DECLINED = "declined";

	@Override
	public void getAllRequests() {

		List<ReimbursementDetails> details = reimbursementDao.getReimbursementDetails();
		for (ReimbursementDetails r : details) {

			IReimbursementService object = new ReimbursementServiceImpl();
			status = r.getStatus();
			employeeID = r.getEmployeeId();
			reimbAmount = r.getReimbursementAmount();

			if (status == null) {
				grade = reimbursementDao.getGrade(employeeID);
				baseSalary = reimbursementDao.getBasicSalary(grade);
				valid = object.validity(baseSalary, r.getReimbursementAmount());
				if (valid) {
					reimbursementDao.updateReimb(employeeID, APPROVED);
					reimbursementDao.updateApprovedAllowance(employeeID, reimbAmount);
				} else {
					reimbursementDao.updateReimb(r.getEmployeeId(), DECLINED);
					reimbursementDao.updateApprovedAllowance(r.getEmployeeId(), REIMBDECLINE);
				}
			}
		}
	}

	public boolean validity(int basic, int reimbAmount) {

		reimbLimit = basic * PERC;
		if (reimbAmount <= reimbLimit) {
			return true;
		}
		return false;
	}

	@Override
	public String saveAppliedReimbursement(Long empId, Long appliedReimbursementAmt) {

		String dbSaveStatus = reimbursementDao.updateAppliedReimbursement(empId, appliedReimbursementAmt);
		return dbSaveStatus;
	}

}