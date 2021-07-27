package com.empmanagement.serviceimpl;

import com.empmanagement.dao.IPerformanceManagementDAO;
import com.empmanagement.domain.PerformanceManagement;
import com.empmanagement.service.IReviewsService;

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
