package com.empmanagement.service;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.EmpregisterDAO;
import com.empmanagement.dao.EmpregisterDAOImpl;

@Service
public class EmpRegImpl implements EmpReg{
	
	@Autowired
	EmpregisterDAO empregdao = new EmpregisterDAOImpl();
	int empId;
	String username;
	String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String smallLetters = "abcdefghijklmnopqrstuvwxyz";
    String num = "0123456789";
    String sp_char = "!@#$%^&*_=+-/.?<>)";

	public Integer getDeptId(String deptname) {
		int deptId = empregdao.getDeptId(deptname);	
		return deptId;
	}
	
	public String generateEmail(String firstname, String lastname) {

		String email = firstname+lastname+String.valueOf(random())+"@orgdomain.com";		
		return email;
			
	}
	public String getFullName(String firstname, String lastname) {
		String name = firstname+" "+lastname;
		return name;
	}

	public String getEmpUserName(String firstname, String lastname) {
		
		username = firstname + lastname + String.valueOf(random());
		return username;
	}
	
	private int random() {
		Random random = new Random();
		int num =  random.nextInt(9000) + 1000;
		return num;
	}
	
	public String getPassword() {
		
		String combined = capitalLetters + smallLetters + num + sp_char;
		Random random = new Random();
		char[] password = new char[8];
		for (int i = 0; i < password.length; i++)
	        {
	            password[i] = combined.charAt(random.nextInt(combined.length()));
	  
	        }
		return String.valueOf(password);
	}
}
