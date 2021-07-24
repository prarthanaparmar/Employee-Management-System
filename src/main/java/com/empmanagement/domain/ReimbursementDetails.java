package com.empmanagement.domain;

import org.springframework.stereotype.Component;

@Component
public class ReimbursementDetails {
	
	public ReimbursementDetails() {
		
	}
	
	int reimbursementId;
	Long employeeId;
	int reimbursementAmount;
	String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public int getReimbursementAmount() {
		return reimbursementAmount;
	}
	public void setReimbursementAmount(int reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}
	

}
