package com.empmanagement.service;

public interface IReimbursementService {

	void getAllRequests();
	boolean validity(int basic, int reimbAmount);
}
