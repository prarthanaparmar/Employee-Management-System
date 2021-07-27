
package com.empmanagement.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.empmanagement.dao.IAuthenticationDAO;
import com.empmanagement.serviceimpl.AuthenticationServiceImpl;
import com.empmanagement.util.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author Priti Sri Pandey
 *
 */
@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceImplTest {

	@Mock
	private IAuthenticationDAO authenticationDao;

	@InjectMocks
	AuthenticationServiceImpl authenticationService;

	private static final String PASSWORD = "testPassword";
	private static final String WRONG_PASSWORD = "someOtherPassword";
	private static final String USERNAME = "XBBLWG4";
	private static final String ERROR = "error";
	private static final Long EMPID = (long) 13011;

	@Test
	void validatePasswordSuccess() throws NoSuchAlgorithmException {
		Mockito.when(authenticationDao.getPasswordFromDatabase(USERNAME))
				.thenReturn(PasswordEncoder.encodePassword(PASSWORD));
		String enteredPassword = PASSWORD;
		boolean returnedPassword = authenticationService.validatePassword(USERNAME, enteredPassword);
		assertEquals(true, returnedPassword);
	}

	@Test
	void validatePasswordFailure() throws NoSuchAlgorithmException {
		Mockito.when(authenticationDao.getPasswordFromDatabase(USERNAME))
				.thenReturn(PasswordEncoder.encodePassword(PASSWORD));
		String enteredPassword = WRONG_PASSWORD;
		boolean returnedPassword = authenticationService.validatePassword(USERNAME, enteredPassword);
		assertEquals(false, returnedPassword);
	}

	@Test
	void updatePasswordError() throws NoSuchAlgorithmException {
		Mockito.when(authenticationDao.updatePassword(EMPID, PASSWORD)).thenReturn(ERROR);
		String enteredPassword = PASSWORD;
		String status = authenticationService.updatePassword(EMPID, enteredPassword);
		assertEquals(ERROR, status);
	}

}