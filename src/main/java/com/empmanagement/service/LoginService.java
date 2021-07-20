package com.empmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.ILoginDAO;

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
		if (password.equals(savedPassword)) {
			doesPasswordMatch = true;

		} else {
			doesPasswordMatch = false;
		}

		return doesPasswordMatch;
	}

	public Long getEmpID(String userName) {

		Long empId = loginDao.getEmpIDFromDatabase(userName);
		return empId;
	}

}
