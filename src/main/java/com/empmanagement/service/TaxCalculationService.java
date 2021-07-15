package com.empmanagement.service;

import org.springframework.stereotype.Service;

@Service
public interface TaxCalculationService {
	public double caculateIncomeTax(Long empId, double totalEarnings);
	public double calculateProfessionalTax(double totalEarnings);
}
