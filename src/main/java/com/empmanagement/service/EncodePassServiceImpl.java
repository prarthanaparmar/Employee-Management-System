package com.empmanagement.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service
public class EncodePassServiceImpl implements IEncodePassService{
	
	static final int BIGINTCONSTANT = 1;
	static final int HEXINT = 0;
	static final char HEXCHAR ='0';
	static final int LENGTH = 32;
	
	
	public String encodePassword(String password) throws NoSuchAlgorithmException {
		
		 return toHexString(encryptPass(password));
		
	}
	
	private byte[] encryptPass(String password) throws NoSuchAlgorithmException {
		
		 MessageDigest mdigest = MessageDigest.getInstance("SHA-256"); 
		 return mdigest.digest(password.getBytes(StandardCharsets.UTF_8));
	}
	
	private String toHexString(byte[] hash) {
		
		BigInteger num = new BigInteger(BIGINTCONSTANT, hash); 
		StringBuilder hex = new StringBuilder(num.toString());
		
		while (hex.length() < LENGTH) 
       { 
           hex.insert(HEXINT, HEXCHAR); 
       } 
 
       return hex.toString(); 
	}	
}
