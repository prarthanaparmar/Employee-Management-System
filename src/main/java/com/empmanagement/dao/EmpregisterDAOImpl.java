package com.empmanagement.dao;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpregisterDAOImpl implements IEmpregisterDAO {
	@Autowired
	private  JdbcTemplate jdbcTemplate = new JdbcTemplate();
	String dbupdatestatus;
	int deptId;
	String loginupdate;
	Long empId;
	String username;
	
	public String registerEmp(String name,String email,Date doj,Date dob, String role,String grade,int deptId,String team,String status,String personalEmail) {
		try{
			int dbUpdate = jdbcTemplate.update(
					"INSERT INTO employee(empName,empEmail,DOJ,DOB,role,grade,deptId,team,status,personalEmail) values(?,?,?,?,?,?,?,?,?,?)",
					name, email, doj, dob, role, grade, deptId,team,status,personalEmail);			
			if(dbUpdate>0) {
			dbupdatestatus = "success";
			}
		}
		catch (Exception e){
			e.printStackTrace();
			dbupdatestatus = "error";
		}
		return dbupdatestatus;
	}
	public int getDeptId(String deptname) {
		try {
			
	     deptId = jdbcTemplate.queryForObject("select iddept from dept where deptname = ?",
				int.class, deptname);	    	 
		}
		catch (Exception e){
			e.printStackTrace();
			deptId = 0;
		}
		System.out.println(deptId);
		return deptId;
	}
	
	public String loginDetails(String username, String password, Long empId) {
		try {
			int update = jdbcTemplate.update("INSERT INTO login(empUsername, empPassword, empId) values (?,?,?)", username, password,empId);
			System.out.println("Successfully added values"+update);
			loginupdate = "success";
		}
		catch (Exception e){
			e.printStackTrace();
			loginupdate = "error";
		}
		return loginupdate;
		
	}
	
	public Long getEmpId(String empName, Date DOB) {
		
		try {
						
		     empId = jdbcTemplate.queryForObject("select empId from employee where empName = ? && DOB = ?  ",
					Long.class, empName, DOB);
		     System.out.println("ID : " + empId);
			}
			catch (Exception e){
				e.printStackTrace();
				empId = (long) 0;
			}
			return empId;
	}
	@Override
	public String getUsername(Long empId) {
		
		try {
			username = jdbcTemplate.queryForObject("select empUsername from login where empId = ?",String.class,empId);
			System.out.println(username);
		}
		catch (Exception e){
			e.printStackTrace();
		}		
		return username;
	}
}
