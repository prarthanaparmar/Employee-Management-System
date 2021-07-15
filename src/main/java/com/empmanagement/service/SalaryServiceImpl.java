package com.empmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.SalaryDAO;
import com.empmanagement.domain.Deductions;
import com.empmanagement.domain.Earnings;
import com.empmanagement.domain.Salary;
import com.empmanagement.domain.Taxes;

@Service
public class SalaryServiceImpl implements SalaryService {

	@Autowired
	EarningCalculationService earningService;

	@Autowired
	DeductionService deductionService;

	@Autowired
	SalaryDAO dao;

	double basicPay = 0;
	double totalEarning = 0;
	double totalDeductions = 0;
	double netPay = 0;
	Earnings earnings;

	@Override
	public Salary getSalaryForEmployee(Long empId) {

		earnings = earningService.calculateTotalEarnings(getBasicPayForEmployee(empId), empId);
		totalEarning = earnings.getBasic() + earnings.getHra() + earnings.getAllowances() + earnings.getShiftAllowance();

		Deductions deductions = deductionService.getTotalDeductions(totalEarning);
		totalDeductions = deductions.getTax().getProfessionalTax() + deductions.getTax().getIncomeTax() + deductions.getProvidentFund();
		netPay = totalEarning - totalDeductions;

		Salary salary = new Salary();
		salary.setEarnings(earnings);
		salary.setNetPay(netPay);
		salary.setDeductions(deductions);

		return salary;

	}

	@Override
	public double getBasicPayForEmployee(Long empId) {
		basicPay = dao.getBasicSalary(empId);
		return basicPay;
	}

}
