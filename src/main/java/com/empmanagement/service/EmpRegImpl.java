package com.empmanagement.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.IEmpregisterDAO;
import com.empmanagement.dao.EmpregisterDAOImpl;

@Service
public class EmpRegImpl implements IEmpReg{
	
	@Autowired
	IEmpregisterDAO empregdao = new EmpregisterDAOImpl();
	int empId;
	String username;
	static final String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String smallLetters = "abcdefghijklmnopqrstuvwxyz";
    static final String num = "0123456789";
    static final String sp_char = "!@#$%^&*_=+-/.?<>)";
    static final int num_char_pass = 8;

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
	
	public String getPassword() throws NoSuchAlgorithmException {
		
		String combined = capitalLetters + smallLetters + num + sp_char;
		Random random = new Random();
		char[] password = new char[num_char_pass];
		for (int i = 0; i < password.length; i++)
	        {
	            password[i] = combined.charAt(random.nextInt(combined.length()));
	  
	        }
		return toHexString(encryptPass(String.valueOf(password)));
	}
	
	private byte[] encryptPass(String password) throws NoSuchAlgorithmException {
		
		 MessageDigest mdigest = MessageDigest.getInstance("SHA-256"); 
		 return mdigest.digest(password.getBytes(StandardCharsets.UTF_8));
		 
	}
	
	private String toHexString(byte[] hash) {
		
		BigInteger num = new BigInteger(1, hash); 
		StringBuilder hex = new StringBuilder(num.toString());
		
		while (hex.length() < 32) 
        { 
            hex.insert(0, '0'); 
        } 
  
        return hex.toString(); 
	}
	
}
