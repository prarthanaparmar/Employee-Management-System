package com.empmanagement.service;

public interface ReimbursementService {

	public void getAllRequests();
	public boolean validity(int basic, int reimbAmount);
}
