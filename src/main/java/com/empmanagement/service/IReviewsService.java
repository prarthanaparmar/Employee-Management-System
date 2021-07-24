package com.empmanagement.service;

import com.empmanagement.domain.PerformanceManagement;

import java.util.List;

public interface IReviewsService {
    public List<PerformanceManagement> getReviews(String empId);
}
