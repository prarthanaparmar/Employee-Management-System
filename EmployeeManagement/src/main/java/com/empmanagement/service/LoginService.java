package com.empmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.LoginDAO;


@Service
public class LoginService {

	@Autowired
	LoginDAO loginDao;

	boolean doesPasswordMatch;

	public boolean validatePassword(String userName, String password) {

		String savedPassword = loginDao.getPasswordFromDatabase(userName);
		if (password.equals(savedPassword)) {

			doesPasswordMatch = true;

			System.out.println("Password Matches");

		} else {
			doesPasswordMatch = false;
			System.out.println("Password doesn't match");
		}

		return doesPasswordMatch;
	}

}
