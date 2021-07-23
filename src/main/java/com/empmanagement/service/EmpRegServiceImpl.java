package com.empmanagement.service;

import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.IEmpregisterDAO;

@Service
public class EmpRegServiceImpl implements IEmpRegService{
	
	@Autowired
	IEmpregisterDAO empregdao;
	
	@Autowired
	private IRandomService randService;
	
	int empId;
	String username;
	static final String CAPITAL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String SMALL = "abcdefghijklmnopqrstuvwxyz";
    static final String NUM = "0123456789";
    static final String SPCHAR = "!@#$%^&*_=+-/.?<>)";
    static final int NUMOFCHAR = 8;

	public Integer getDeptId(String deptname) {
		int deptId = empregdao.getDeptId(deptname);	
		return deptId;
	}
	
	public String generateEmail(String firstname, String lastname) {

		String email = firstname+lastname+String.valueOf(randService.random())+"@orgdomain.com";		
		return email;
			
	}
	public String getFullName(String firstname, String lastname) {
		String name = firstname+" "+lastname;
		return name;
	}

	public String getEmpUserName(String firstname, String lastname) {
		
		username = firstname + lastname + String.valueOf(randService.random());
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
	
}
