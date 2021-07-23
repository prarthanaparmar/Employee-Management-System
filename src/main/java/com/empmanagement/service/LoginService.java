package com.empmanagement.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.ILoginDAO;
import com.empmanagement.util.PasswordEncoder;

/**
 * @author Priti Sri Pandey
 */
@Service
public class LoginService {

	@Autowired
	ILoginDAO loginDao;

	boolean doesPasswordMatch;

	public boolean validatePassword(String userName, String password) {

		String savedPassword = loginDao.getPasswordFromDatabase(userName);
		try {
			if (PasswordEncoder.encodePassword(password).equals(savedPassword)) {
				doesPasswordMatch = true;

			} else {
				doesPasswordMatch = false;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return doesPasswordMatch;
	}

	public Long getEmpID(String userName) {

		Long empId = loginDao.getEmpIDFromDatabase(userName);
		return empId;
	}

}
