package com.empmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.IInvestmentDeclarationDAO;
import com.empmanagement.domain.InvestmentDeclaration;

/**
 * This class is the service layer implementation of calculating total
 * investments
 * 
 * @author Priti Sri Pandey
 *
 */
@Service
public class InvestmentDeclarationServiceImpl implements IInvestmentDeclarationService {

	@Autowired
	IInvestmentDeclarationDAO investmentDAO;

	InvestmentDeclaration investment = null;

	@Override
	public InvestmentDeclaration getInvestmentDeclaration(Long empId) {

		investment = investmentDAO.getInvestmentDeclaration(empId);

		return investment;

	}

	@Override
	public String saveInvestmentDeclaration(Long empId, Long homeLoanInterest, Long lifeInsuranceInvestment,
			Long mutualFundInvestment) {
		String dbSaveStatus = investmentDAO.saveInvestmentDeclaration(empId, homeLoanInterest, lifeInsuranceInvestment,
				mutualFundInvestment);

		return dbSaveStatus;

	}

}
