package com.empmanagement.serviceimpl;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.IAuthenticationDAO;
import com.empmanagement.service.IAuthenticationService;
import com.empmanagement.util.PasswordEncoder;

/**
 * @author Priti Sri Pandey
 */
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

	@Autowired
	IAuthenticationDAO authenticationDao;

	boolean doesPasswordMatch;

	@Override
	public boolean validatePassword(String userName, String password) {
		String savedPassword = authenticationDao.getPasswordFromDatabase(userName);
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

	@Override
	public Long getEmpID(String userName) {
		Long empId = authenticationDao.getEmpIDFromDatabase(userName);
		return empId;
	}

	@Override
	public String updatePassword(Long empId, String password) {
		String dbSaveStatus = "error";
		try {
			dbSaveStatus = authenticationDao.updatePassword(empId, PasswordEncoder.encodePassword(password));
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return dbSaveStatus;
	}

}
