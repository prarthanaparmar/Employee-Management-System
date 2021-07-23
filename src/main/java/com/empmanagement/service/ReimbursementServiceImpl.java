package com.empmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.IReimbursementDao;
import com.empmanagement.dao.ReimbursementDaoImpl;
import com.empmanagement.domain.ReimbursementDetails;
import com.mysql.cj.conf.BooleanPropertyDefinition.AllowableValues;

@Service
public class ReimbursementServiceImpl implements IReimbursementService{

	@Autowired
	IReimbursementDao reimbursementDao = new ReimbursementDaoImpl();
	
	static final int REIMBDECLINE = 0;
	static final double PERC = 0.1;
	static final String APPROVED = "approved";
	static final String DECLINED = "declined";

	private String updateReim;
	private String allow;
	
	@Override
	public String getAllRequests() {	

		List<ReimbursementDetails> details = reimbursementDao.getReimbursementDetails();
		for(ReimbursementDetails r:details) {
			
			IReimbursementService object = new ReimbursementServiceImpl();
		 	String status = r.getStatus();
			Long employeeID = r.getEmployeeId();	
			int reimbAmount = r.getReimbursementAmount();
			
			if(status == null){				
				String grade = reimbursementDao.getGrade(employeeID);
				int baseSalary = reimbursementDao.getBasicSalary(grade);
				boolean valid = object.validity(baseSalary, r.getReimbursementAmount());
				if(valid){					
					updateReim = reimbursementDao.updateReimb(employeeID,APPROVED);
					allow = reimbursementDao.updateAllowance(employeeID,reimbAmount);
					if(updateReim == "success" && allow == "success") {
						continue;
					}
					else {
						return "error";
					}
					}
				else {					
					updateReim = reimbursementDao.updateReimb(r.getEmployeeId(),DECLINED);
					allow = reimbursementDao.updateAllowance(r.getEmployeeId(),REIMBDECLINE);
					if(updateReim == "success" && allow == "success") {
						continue;
					}
					else {
						return "error";
					}
					}
				}
			}
		return "success";
		}
	
	public boolean validity(int basic, int reimbAmount) {
		
		double reimbLimit = basic*PERC;
		if(reimbAmount <= reimbLimit) {
			return true;
		}
		return false;				
	}
	

}