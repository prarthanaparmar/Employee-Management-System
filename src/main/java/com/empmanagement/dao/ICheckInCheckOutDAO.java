package com.empmanagement.dao;

import com.empmanagement.domain.CheckInOutDetails;
import com.empmanagement.domain.TimeSheetDetail;
import org.springframework.stereotype.Component;

import java.io.LineNumberInputStream;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Component
public interface ICheckInCheckOutDAO {
    void setCheckIn(Long empId);
    public void updateCheckIn(Long empId);
    //Boolean getEmpID(Long eid,Date date);
    public void setCheckOut(Long empId, Date date);
    List<CheckInOutDetails> getTimeSheetDetail(Long empId);
    List<CheckInOutDetails> getdate(Long empId);
    Time getendtime(Long empId);
    public Time getstarttime(Long empId);

}
