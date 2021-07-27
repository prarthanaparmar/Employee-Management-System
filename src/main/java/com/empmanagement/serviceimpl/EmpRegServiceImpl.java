package com.empmanagement.serviceimpl;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Random;

import com.empmanagement.dao.EmpregisterDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanagement.dao.IEmpregisterDAO;
import com.empmanagement.service.IEmpRegService;
import com.empmanagement.util.RandomUtils;

@Service
public class EmpRegServiceImpl implements IEmpRegService{
	
	@Autowired
	IEmpregisterDAO empregdao = new EmpregisterDAOImpl();

	private RandomUtils randUtils = new RandomUtils();

	String username;
	String name;
	String email;
	String update;
	int deptId;
	Long empId;
	static final String CAPITAL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String SMALL = "abcdefghijklmnopqrstuvwxyz";
    static final String NUM = "0123456789";
    static final String SPCHAR = "!@#$%^&*_=+-/.?<>)";
    static final int NUMOFCHAR = 8;

    
    @Override
	public String registerEmp(String name, String email, Date doj, Date dob, String role, String grade, int deptId,
			String team, String status, String personalEmail) {
    	update = empregdao.registerEmp(name, email, doj, dob, role, grade, deptId, team, status, personalEmail);
		return update;
	}

	@Override
	public Integer getDeptId(String deptname) {
		deptId = empregdao.getDeptId(deptname);
		return deptId;
	}

	@Override
	public String generateEmail(String firstname, String lastname) {
		email = firstname+lastname+randUtils.random()+"@orgdomain.com";
		return email;
	}

	@Override
	public String getFullName(String firstname, String lastname) {
		name = firstname+" "+lastname;
		return name;
	}

	@Override
	public String getEmpUserName(String firstname, String lastname) {
		username = firstname + lastname + randUtils.random();
		return username;
	}

	@Override
	public String getPassword() throws NoSuchAlgorithmException {
		String combined = CAPITAL + SMALL + NUM + SPCHAR;
		Random random = new Random();
		char[] password = new char[NUMOFCHAR];
		for (int i = 0; i < password.length; i++)
	        {
	            password[i] = combined.charAt(random.nextInt(combined.length()));
	        }
		return String.valueOf(password);
	}

	@Override
	public Long getEmpId(String empName, Date DOB) {
		empId = empregdao.getEmpId(empName, DOB);
		return empId; 
	}

	@Override
	public String updateLogin(String username, String password, Long empId) {
		update = empregdao.loginDetails(username, password, empId);
		return update;
	}

	@Override
	public String getUsername(Long empId) {
		username = empregdao.getUsername(empId);
		return username;
	}
}
