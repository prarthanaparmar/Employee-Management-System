package com.empmanagement.service;

import org.springframework.stereotype.Service;

/*
 * Interface for TimeSheet overtime check for current week
 * @author: Dhruv Bharatbhai Patel (B00868931)
 * */
@Service
public interface ITimeSheetOverTimeLimit {
    /* Method to check if an employee has worked more than 40 hours/week. */
    public boolean getOvertimeLimit(String userId);
}
