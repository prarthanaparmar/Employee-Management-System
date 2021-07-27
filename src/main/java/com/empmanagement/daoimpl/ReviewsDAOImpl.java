package com.empmanagement.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.empmanagement.dao.IReviewsDAO;

@Repository
public class ReviewsDAOImpl implements IReviewsDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

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
