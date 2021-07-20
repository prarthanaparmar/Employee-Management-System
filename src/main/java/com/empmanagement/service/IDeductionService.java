package com.empmanagement.service;

import com.empmanagement.domain.Deductions;

/**
 * Interface for Deduction services
 * @author Priti Sri Pandey
 */
public interface IDeductionService {

	public Deductions getTotalDeductions(Long empId, double totalEarnings);
	
}
