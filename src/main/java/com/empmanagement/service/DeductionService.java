package com.empmanagement.service;

import com.empmanagement.domain.Deductions;

public interface DeductionService {

	public Deductions getTotalDeductions(Long empId, double totalEarnings);
	
}
