package com.empmanagement.service;

import org.springframework.stereotype.Service;

@Service
public interface TaxCalculationService {
	public double caculateIncomeTax(double basicSalary);
	public double calculateProfessionalTax(double basicSalary);
}
