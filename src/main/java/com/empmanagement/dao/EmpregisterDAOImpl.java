package com.empmanagement.dao;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpregisterDAOImpl implements IEmpregisterDAO {
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	String dbupdatestatus;
	int deptId;
	String loginupdate;
	int empId;
	
	public String registerEmp(String name,String email,Date doj,Date dob, String role,String grade,int deptId,String team) {
		try{
			int dbupdate = jdbcTemplate.update(
					"INSERT INTO employee(empName,empEmail,DOJ,DOB,role,grade,deptId,team) values(?,?,?,?,?,?,?,?)",name, email, doj, dob, role, grade, deptId,team);
			System.out.println("Successfully added values"+dbupdate);
			dbupdatestatus = "success";
		}
		catch (Exception e){
			System.out.println(e);
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
			System.out.println(e);
		}
		return deptId;
	}
	
	public String loginDetails(String username, String password, int empId) {
		try {
			int update = jdbcTemplate.update("INSERT INTO login(empUsername, empPassword, empId) values (?,?,?)", username, password,empId);
			System.out.println("Successfully added values"+update);
			loginupdate = "success";
		}
		catch (Exception e){
			System.out.println(e);
			loginupdate = "error";
		}
		return loginupdate;
		
	}
	
	public int getEmpId(String empName, Date DOB) {
		
		try {
						
		     empId = jdbcTemplate.queryForObject("select empId from employee where empName = ? && DOB = ?  ",
					int.class, empName, DOB);
			}
			catch (Exception e){
				System.out.println(e);
			}
			return empId;
	}
}
