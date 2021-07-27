package com.empmanagement.dao;

import com.empmanagement.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This DAO(Data access Object) class communicates to database to perform CRUD operation related to manager reviews.
 * */
@Repository
public class PerformanceManagementDAOImpl implements IPerformanceManagementDAO {
    private static final String TABLE_REVIEWS="reviews";
    private static final String QUERY_GET_SCORES="Select * from "+TABLE_REVIEWS+" r where r.empId2 =";
    private static final String QUERY_GET_REVIEWED_REVIEWS="Select * from "+TABLE_REVIEWS+" r where r.empId1 =";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*
    * This method gets the list of reviews from database
    *
    * @param empId Employee ID of an employee
    * @returns List of PerformanceManagement or null
    * */
    public List<PerformanceManagement> getScores(String empId){
        try {
            String sql = QUERY_GET_SCORES + empId;
            List<PerformanceManagement> performanceManagements = jdbcTemplate.query(sql, new PerformanceManagementRowMapper());
            return performanceManagements;
        }
        catch(Exception exception){
            System.out.println("Exception occured at while fetching review scores: "+ exception.getMessage());
            return null;
        }
    }

    /*
    * This method gets the list of history of reviews from database
    *
    * @param empId Employee ID of an employee
    * @returns List of PerformanceManagement or null
    * */
    public List<PerformanceManagement> getReviewedReviews(String empId){
        try {
            String sql = QUERY_GET_REVIEWED_REVIEWS + empId;
            List<PerformanceManagement> performanceManagements = jdbcTemplate.query(sql, new PerformanceManagementRowMapper());
            return performanceManagements;
        }
        catch(Exception exception){
            System.out.println("Exception occured at while fetching history of reviews: "+ exception.getMessage());
            return null;
        }
    }
}
