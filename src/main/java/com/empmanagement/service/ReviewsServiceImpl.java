package com.empmanagement.service;

import com.empmanagement.dao.IPerformanceManagementDAO;
import com.empmanagement.domain.PerformanceManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewsServiceImpl implements IReviewsService {

    @Autowired
    IPerformanceManagementDAO performanceManagementDAO;

    public List<PerformanceManagement> getReviews(String empId){
        List<PerformanceManagement> performanceManagementList=performanceManagementDAO.getReviewedReviews(empId);
        return performanceManagementList;
    }
}
