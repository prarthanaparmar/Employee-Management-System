package com.empmanagement.service;

import org.springframework.stereotype.Service;

@Service
public interface ICheckInOutService {
    public boolean addCheckIn(long empId);
    public boolean addCheckOut(long empId);
}
