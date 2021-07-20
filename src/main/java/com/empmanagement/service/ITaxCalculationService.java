package com.empmanagement.service;

import org.springframework.stereotype.Service;

/**
 * Interface for Tax Calculation services
 * @author Priti Sri Pandey
 */
@Service
public interface ITaxCalculationService {
	public double caculateIncomeTax(Long empId, double totalEarnings);
	public double calculateProfessionalTax(double totalEarnings);
}
