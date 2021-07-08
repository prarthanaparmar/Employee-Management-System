package com.empmanagement.service;
import com.empmanagement.domain.EmployeeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.LoginDAO;


@Service
public class LoginService {

	@Autowired
	LoginDAO loginDao;
	@Autowired
	private EmployeeDetail employeeDetail;

	boolean doesPasswordMatch;

	public boolean validatePassword(String userName, String password) {

		String savedPassword = loginDao.getPasswordFromDatabase(userName);
		if (password.equals(savedPassword)) {

			doesPasswordMatch = true;
			employeeDetail.setUserName(userName);
			System.out.println("Password Matches");

		} else {
			doesPasswordMatch = false;
			System.out.println("Password doesn't match");
		}

		return doesPasswordMatch;
	}

	public String setEmployeeId(String userName){
		String id=loginDao.getId(userName);

		if(!id.isEmpty()){
			employeeDetail.setEmpId(id);
		}

		return id;
	}

}
