package com.empmanagement.dao;

import java.util.List;

import com.empmanagement.domain.ReimbursementDetails;

public interface IReimbursementDao {
	
	List<ReimbursementDetails> getReimbursementDetails();
	String getGrade(int empID);
	int getBasicSalary(String grade);
	String getStatus(int reimbID);
	String updateReimb(int reimbursementId, String status);
}
