package com.empmanagement.service;

import com.empmanagement.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface IPerformanceManagementService {
    public Map<String,Double> getScores(String empId);
    public boolean checkPendingReviews(String empId);
}
