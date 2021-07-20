package com.empmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.ReimbursementDao;
import com.empmanagement.dao.ReimbursementDaoImpl;
import com.empmanagement.domain.ReimbursementDetails;

import ch.qos.logback.core.status.Status;

@Service
public class ReimbursementServiceImpl implements ReimbursementService{

	@Autowired
	ReimbursementDao reimbursementDao = new ReimbursementDaoImpl();
	private int baseSalary;
	private String grade;
	private double reimbLimit;
	private boolean valid;
	private String status;
	private int employeeID;
	
	@Override
	public void getAllRequests() {

		List<ReimbursementDetails> details = reimbursementDao.getReimbursementDetails();
		for(ReimbursementDetails r:details) {
			
			ReimbursementService object = new ReimbursementServiceImpl();
			System.out.print("ReimbursementID:" + r.getReimbursementId());
			System.out.print("Amount:" + r.getReimbursementAmount());
			System.out.print("empID:" +  r.getEmployeeId());
			employeeID = r.getEmployeeId();
			status = r.getStatus();
			if(status == null) {
				grade = reimbursementDao.getGrade(employeeID);
				baseSalary = reimbursementDao.getBasicSalary(grade);
				valid = object.validity(baseSalary, r.getReimbursementAmount());
				if(valid){
					reimbursementDao.updateReimb(r.getReimbursementId(),"approved");
					}
				else {
					reimbursementDao.updateReimb(r.getReimbursementId(),"declined");
					}
				}
			}
		}
	
	public boolean validity(int basic, int reimbAmount) {
		
		reimbLimit = basic*0.1;
		if(reimbAmount <= reimbLimit) {
			return true;
		}
		return false;				
	}
	

}