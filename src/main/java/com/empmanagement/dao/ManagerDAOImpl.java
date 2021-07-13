package com.empmanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerDAOImpl implements ManagerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    String managerScore;
    Long empId;

    /*
     * Gets manger score from database for the employee
     */
    public String getApraisalDetailsFromDatabase(Integer empId) {

        try {

            managerScore = jdbcTemplate.queryForObject("select manager_score from performance_management where empId= ?",
                    String.class, empId);

        } catch (Exception e) {

            System.err.println(e);
        }

        return managerScore;
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
