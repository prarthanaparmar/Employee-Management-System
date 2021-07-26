package com.empmanagement.service;

import org.springframework.stereotype.Service;

/*
 * Interface for TimeSheet overtime check for current week
 * @author: Dhruv Bharatbhai Patel (B00868931)
 * */
@Service
public interface ITimeSheetOverTimeLimit {
    public boolean getOvertimeLimit(String userId);
}
