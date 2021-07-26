package com.empmanagement.service;

import com.empmanagement.domain.TimeSheetDetail;
import org.springframework.stereotype.Service;
import java.util.List;

/*
* Interface for TimeSheetService
* @author: Dhruv Bharatbhai Patel (B00868931)
* */
@Service
public interface ITimeSheetService {
    public List<TimeSheetDetail> getTimeSheetDetails(String userId);
    public List<TimeSheetDetail> getFutureTimeSheetDetails(String userId);
    public String getHoursWorked(String userId);
    public String getCurrentMonthlyHoursDetail(String userId);
    public String getCurrentWeeklyHoursDetail(String userId);
}
