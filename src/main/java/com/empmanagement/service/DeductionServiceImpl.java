package com.empmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.domain.Deductions;
import com.empmanagement.domain.Taxes;

/**
 * This class is the service layer implementation of calculating total deductions
 * @author Priti Sri Pandey
 *
 */
@Service
public class DeductionServiceImpl implements IDeductionService {

	@Autowired
	ITaxCalculationService taxService;

	double incomeTax = 0;
	double professionalTax = 0;

	@Override
	public Deductions getTotalDeductions(Long empId, double totalEarnings) {
		incomeTax = taxService.caculateIncomeTax(empId, totalEarnings);
		professionalTax = taxService.calculateProfessionalTax(totalEarnings);

		Taxes totalTaxes = new Taxes();
		totalTaxes.setIncomeTax(incomeTax);
		totalTaxes.setProfessionalTax(professionalTax);

		Deductions totalDeductions = new Deductions();
		totalDeductions.setTax(totalTaxes);
		return totalDeductions;
	}

}
