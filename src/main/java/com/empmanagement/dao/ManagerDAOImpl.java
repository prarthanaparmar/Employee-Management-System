package com.empmanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerDAOImpl implements ManagerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //String empPassword;
    Long empId;

    /*
     * Gets the password from database for the employee
     */
    public String getPasswordFromDatabase(String userName) {

        try {

            empPassword = jdbcTemplate.queryForObject("select empPassword from login where empUsername = ?",
                    String.class, userName);

        } catch (Exception e) {

            System.err.println(e);
        }

        return empPassword;
    }


    /*
     * Gets the empId from database for the userName
     */
    public Long getManagerEmpIDFromDatabase(String deptName) {

        try {

            empId = jdbcTemplate.queryForObject("select empId,empName,deptId from employee where role=\"manager\" && deptId=(select Iddept from dept where deptname=?);",
                    Long.class, deptName);

        } catch (Exception e) {

            System.err.println(e);
        }

        return empId;
    }


}
