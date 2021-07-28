package com.empmanagement.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.test.util.ReflectionTestUtils;

import com.empmanagement.daoimpl.AuthenticationDAOImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 
 * @author Priti Sri Pandey
 *
 */
@ExtendWith(MockitoExtension.class)
public class AuthenticationDAOImplTest {

	@Mock
	private JdbcTemplate jdbcTemplate;

	@InjectMocks
	private AuthenticationDAOImpl authDao;

	private static final String USER_NAME = "PriPan";
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	private static final Long EMP_ID = (long) 13011;
	private static final String TEST_PASSWORD = "TestPassword";
	private static final String QUERY_GET_PASSWORD = "select empPassword from login where empUsername = ?";
	private static final String QUERY_UPDATE_PASSWORD = "UPDATE login SET empPassword = ? WHERE empId = ?";

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(authDao, "jdbcTemplate", jdbcTemplate);
	}

	@Test
	public void getPasswordFromDatabaseTest() {

		ReflectionTestUtils.setField(authDao, "jdbcTemplate", jdbcTemplate);
		Mockito.when(jdbcTemplate.queryForObject(QUERY_GET_PASSWORD, String.class, USER_NAME))
				.thenReturn(TEST_PASSWORD);

		String pass = authDao.getPasswordFromDatabase(USER_NAME);
		assertEquals(pass, TEST_PASSWORD);

	}

	@Test
	public void updatePasswordSuccessTest() {

		ReflectionTestUtils.setField(authDao, "jdbcTemplate", jdbcTemplate);
		Mockito.when(jdbcTemplate.update(QUERY_UPDATE_PASSWORD, TEST_PASSWORD, EMP_ID)).thenReturn(1);

		String dbSaveStatus = authDao.updatePassword(EMP_ID, TEST_PASSWORD);
		assertEquals(dbSaveStatus, SUCCESS);

	}

	@Test
	public void updatePasswordFailedTest() {

		ReflectionTestUtils.setField(authDao, "jdbcTemplate", jdbcTemplate);
		Mockito.when(jdbcTemplate.update(QUERY_UPDATE_PASSWORD, TEST_PASSWORD, EMP_ID)).thenReturn(0);

		String dbSaveStatus = authDao.updatePassword(EMP_ID, TEST_PASSWORD);
		assertEquals(dbSaveStatus, ERROR);

	}

}
