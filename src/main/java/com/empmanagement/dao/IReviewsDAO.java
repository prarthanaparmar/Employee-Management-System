package com.empmanagement.dao;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This DAO(Data access Object) interface will be responsible to perform CRUD operation related to reviews.
 * */
public interface IReviewsDAO {
    /*This method will save the reviews to database*/
    public String saveReview(int empId1,int empId2,String sScore,String cScore,String lScore,String oScore,String date);
}
