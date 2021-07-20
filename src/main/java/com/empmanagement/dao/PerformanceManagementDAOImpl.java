package com.empmanagement.dao;

import com.empmanagement.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class PerformanceManagementDAOImpl implements PerformanceManagementDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PerformanceManagement performanceManagement;

    public List<PerformanceManagement> getScores(String empId){
        String sql="Select * from reviews r where r.empId1 ="+empId;
        List<PerformanceManagement> performanceManagements= jdbcTemplate.query(sql, new PerformanceManagementRowMapper());
        return performanceManagements;
    }

    public List<ManagerEmployeeRelation> getManagers(String empId){
        String sql="Select s.managerId,u.empName from (select * from teams t inner join employee e on t.teams=e.team where e.empId="+empId+") as s inner join (select * from employee emp) as u on s.managerId=u.empId";
        List<ManagerEmployeeRelation> managers= jdbcTemplate.query(sql, new ManagerEmployeeRelationRowMapper());
        return managers;
    }

    public List<EmployeePeer> getPeers(String empId){
        String sql="select t.empId,t.empName from (select * from employee e where e.empId="+empId+") as u inner join (select * from employee emp) as t on u.team=t.team and t.empId!="+empId;
        List<EmployeePeer> performanceManagements= jdbcTemplate.query(sql, new EmployeePeerRowMapper());
        return performanceManagements;
    }

    public String saveReview(int empId1,int empId2,String sScore,String cScore,String lScore,String oScore,String date ){
        String dbSaveStatus=null;
        try {

            int rowsUpdatedInDBTable = jdbcTemplate.update(
                    "INSERT INTO reviews VALUES (?, ? ,?, ?, ?, ?, ?)",
                    empId1,empId2,cScore,sScore,lScore,oScore,date);
            System.out.println("Successfully updated " + rowsUpdatedInDBTable);

            if (rowsUpdatedInDBTable > 0) {
                dbSaveStatus = "success";
            }

        } catch (Exception e) {
            System.err.println(e);
            dbSaveStatus = "error";
        }
        return dbSaveStatus;
    }

}
