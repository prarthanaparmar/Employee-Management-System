package com.empmanagement.dao;

import com.empmanagement.domain.TimeSheetDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TimeSheetDAO {
    public List<TimeSheetDetail> getTimeSheetDetail(String empId);
}
