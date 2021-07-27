package com.empmanagement.daoimpl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.empmanagement.dao.IOffBoardingDao;
/**
 *This class in the data access implementation for employee offboarding.
 *
 * @author Prarthanaben Parmar
 *
 */
@Repository
public class OffBoardingDaoImpl implements IOffBoardingDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String dbStatus;
    static final String STATUS = "Disabled";
    private String email;
    private Date doj;
    private String sql;

    @Override
    public Date getDateOfJoin(Long empId) {

        try {
            sql = "SELECT DOJ FROM employee WHERE empId = ?";
            doj = jdbcTemplate.queryForObject(sql, Date.class, empId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doj;
    }

    @Override
    public String offBoardEmp(Long empId) {

        try {
            sql = "DELETE FROM login WHERE empId = ? ";
            int update = jdbcTemplate.update(sql, empId);
            if (update > 0) {
                dbStatus = "success";
            }
        } catch (Exception e) {
            dbStatus = "error";
            e.printStackTrace();
        }
        return dbStatus;
    }

    @Override
    public String disableUser(Long empId) {

        try {
            sql = "UPDATE employee set status = ? WHERE empId = ? ";
            int status = jdbcTemplate.update(sql, STATUS, empId);
            if (status > 0) {
                dbStatus = "success";
            }
        } catch (Exception e) {
            dbStatus = "error";
            e.printStackTrace();
        }
        return dbStatus;
    }

    @Override
    public String getEMail(Long empId) {

        try {
            sql = "SELECT personalEmail FROM employee WHERE empId = ?";
            email = jdbcTemplate.queryForObject(sql, String.class, empId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return email;
    }
}

