package com.empmanagement.service;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Random;

import com.empmanagement.dao.EmpregisterDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.IEmpregisterDAO;
import com.empmanagement.util.RandomUtils;

@Service
public class EmpRegServiceImpl implements IEmpRegService{
	
	@Autowired
	IEmpregisterDAO empregdao = new EmpregisterDAOImpl();

	private RandomUtils randUtils = new RandomUtils();
	
	int empId;
	String username;
	static final String CAPITAL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String SMALL = "abcdefghijklmnopqrstuvwxyz";
    static final String NUM = "0123456789";
    static final String SPCHAR = "!@#$%^&*_=+-/.?<>)";
    static final int NUMOFCHAR = 8;
    String update;
    
    @Override
	public String registerEmp(String name, String email, Date doj, Date dob, String role, String grade, int deptId,
			String team, String status, String personalEmail) {
    	update = empregdao.registerEmp(name, email, doj, dob, role, grade, deptId, team, status, personalEmail);
		return update;
	}
	   
    
	public Integer getDeptId(String deptname) {
		int deptId = empregdao.getDeptId(deptname);	
		return deptId;
	}
	
	public String generateEmail(String firstname, String lastname) {

		String email = firstname+lastname+String.valueOf(randUtils.random())+"@orgdomain.com";		
		return email;
	}
	public String getFullName(String firstname, String lastname) {
		String name = firstname+" "+lastname;
		return name;
	}

	public String getEmpUserName(String firstname, String lastname) {
		
		username = firstname + lastname + String.valueOf(randUtils.random());
		return username;
	}
	
	public String getPassword() throws NoSuchAlgorithmException {
		
		String combined = CAPITAL + SMALL + NUM + SPCHAR;
		Random random = new Random();
		char[] password = new char[NUMOFCHAR];
		for (int i = 0; i < password.length; i++)
	        {
	            password[i] = combined.charAt(random.nextInt(combined.length()));
	  
	        }
		return String.valueOf(password);
	}


	@Override
	public Long getEmpId(String empName, Date DOB) {
		
		Long empId = empregdao.getEmpId(empName, DOB);
		return empId; 
	}


	@Override
	public String updateLogin(String username, String password, Long empId) {

		String update = empregdao.loginDetails(username, password, empId);
		return update;
	}


	@Override
	public String getUsername(Long empId) {
		String username = empregdao.getUsername(empId);
		return username;
	}

}
