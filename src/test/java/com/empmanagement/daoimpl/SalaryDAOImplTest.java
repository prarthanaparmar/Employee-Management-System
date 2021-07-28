package com.empmanagement.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.test.util.ReflectionTestUtils;

import com.empmanagement.daoimpl.SalaryDAOImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 
 * @author Priti Sri Pandey
 *
 */
@ExtendWith(MockitoExtension.class)
public class SalaryDAOImplTest {

	@Mock
	private JdbcTemplate jdbcTemplate;

	@InjectMocks
	private SalaryDAOImpl salaryDao;

	private static final Long EMP_ID = (long) 13011;
	private static final double MONTHLY_ALLOWANCE = 800;
	private static final double SHIFT_ALLOWANCE = 1200;
	private static final double BASIC_PAY = 6800.0;
	private static final String QUERY_BASIC_SAL = "SELECT salary.basic FROM salary INNER JOIN employee ON employee.grade = salary.grade where employee.empId = ?  ";
	private static final String QUERY_MONTHLY_ALLOWANCE = "SELECT redeemedMAllowance FROM employee where empId = ?  ";
	private static final String QUERY_SHIFT_ALLOWANCE = "SELECT shiftAllowance FROM employee where empId = ?  ";

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(salaryDao, "jdbcTemplate", jdbcTemplate);
	}

	@Test
	public void getBasicSalaryTest() {

		ReflectionTestUtils.setField(salaryDao, "jdbcTemplate", jdbcTemplate);
		Mockito.when(jdbcTemplate.queryForObject(QUERY_BASIC_SAL, Double.class, EMP_ID)).thenReturn(BASIC_PAY);

		double basicPay = salaryDao.getBasicSalary(EMP_ID);
		assertEquals(basicPay, BASIC_PAY);

	}

	public void getMonthlyAllowanceTest() {

		ReflectionTestUtils.setField(salaryDao, "jdbcTemplate", jdbcTemplate);
		Mockito.when(jdbcTemplate.queryForObject(QUERY_MONTHLY_ALLOWANCE, Double.class, EMP_ID))
				.thenReturn(MONTHLY_ALLOWANCE);

		double monthlyAllowance = salaryDao.getMonthlyAllowance(EMP_ID);
		assertEquals(monthlyAllowance, MONTHLY_ALLOWANCE);

	}

	public void getShiftAllowanceTest() {

		ReflectionTestUtils.setField(salaryDao, "jdbcTemplate", jdbcTemplate);
		Mockito.when(jdbcTemplate.queryForObject(QUERY_SHIFT_ALLOWANCE, Double.class, EMP_ID))
				.thenReturn(SHIFT_ALLOWANCE);

		double shiftAllowance = salaryDao.getShiftAllowance(EMP_ID);
		assertEquals(shiftAllowance, SHIFT_ALLOWANCE);

	}

}
