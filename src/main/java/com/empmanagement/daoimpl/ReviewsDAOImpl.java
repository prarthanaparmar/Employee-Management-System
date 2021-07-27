package com.empmanagement.daoimpl;

import com.empmanagement.dao.IReviewsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This DAO(Data access Object) class communicates to database to perform CRUD operation related to general reviews.
 * */
@Repository
public class ReviewsDAOImpl implements IReviewsDAO {
    private static final String TABLE_REVIEWS="reviews";
    private static final String QUERY_SAVE_REVIEWS="INSERT INTO "+TABLE_REVIEWS+" VALUES (?, ? ,?, ?, ?, ?, ?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*
    * This method will save the reviews to database
    *
    * @param empId1 Employee ID of an employee
    * @param empId2 Employee ID of an employee
    * @param sScore skills Score
    * @param cScore communication score
    * @param lScore leadership score
    * @param oScore other score
    * @param date date
    * @returns Success or failure if the review is saved.
    * */
    public String saveReview(int empId1,int empId2,String sScore,String cScore,String lScore,String oScore,String date ){
        String dbSaveStatus=null;
        try {

            int rowsUpdatedInDBTable = jdbcTemplate.update(
                    QUERY_SAVE_REVIEWS,
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
