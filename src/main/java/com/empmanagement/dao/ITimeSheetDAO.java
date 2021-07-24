package com.empmanagement.dao;

import com.empmanagement.domain.TimeSheetDetail;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ITimeSheetDAO {
    List<TimeSheetDetail> getTimeSheetDetail(String empId);
    List<TimeSheetDetail> getFutureTimeSheetDetail(String empId);
    List<TimeSheetDetail> getCurrentMonthDetail(String empId);
    List<TimeSheetDetail> getCurrentWeekDetail(String empId);
}
