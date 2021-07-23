package com.empmanagement.service;

public interface IReimbursementService {

	void getAllRequests();
	boolean validity(int basic, int reimbAmount);
	String saveAppliedReimbursement(Long empId, Long appliedReimbursementAmt);
}
