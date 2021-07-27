package com.empmanagement.daoimpl;

import com.empmanagement.dao.IPerformanceManagementDAO;
import com.empmanagement.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PerformanceManagementDAOImpl implements IPerformanceManagementDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PerformanceManagement> getScores(String empId){
        String sql="Select * from reviews r where r.empId2 ="+empId;
        List<PerformanceManagement> performanceManagements= jdbcTemplate.query(sql, new PerformanceManagementRowMapper());
        return performanceManagements;
    }

    public List<PerformanceManagement> getReviewedReviews(String empId){
        String sql="Select * from reviews r where r.empId1 ="+empId;
        List<PerformanceManagement> performanceManagements= jdbcTemplate.query(sql, new PerformanceManagementRowMapper());
        return performanceManagements;
    }
}
