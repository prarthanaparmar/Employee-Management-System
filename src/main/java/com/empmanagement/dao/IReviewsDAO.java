package com.empmanagement.dao;

public interface IReviewsDAO {
    public String saveReview(int empId1,int empId2,String sScore,String cScore,String lScore,String oScore,String date);
}
