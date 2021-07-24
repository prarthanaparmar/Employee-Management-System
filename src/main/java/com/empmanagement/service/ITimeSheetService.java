package com.empmanagement.service;

import com.empmanagement.domain.TimeSheetDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITimeSheetService {
    public List<TimeSheetDetail> getTimeSheetDetails(String userId);
    public List<TimeSheetDetail> getFutureTimeSheetDetails(String userId);
    public String getHoursWorked(String userId);
    public String getCurrentMonthDetail(String userId);
    public String getCurrentWeekDetail(String userId);
    public boolean getLimit(String userId);
}
