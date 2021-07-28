package com.empmanagement.serviceimpl;

import com.empmanagement.dao.ICheckInCheckOutDAO;
import com.empmanagement.domain.CheckInOutDetails;
import com.empmanagement.service.ICheckInOutService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ICheckInOutServiceImpl implements ICheckInOutService {

    @Autowired
    ICheckInCheckOutDAO checkInCheckOutDAO;



    @Override
    public boolean addCheckIn(long empId) {

        java.util.Date date=new java.util.Date();
        java.sql.Date sqldate= new java.sql.Date(date.getTime());

        LocalTime now=LocalTime.now();
        DateTimeFormatter df=DateTimeFormatter.ofPattern("hh:mm:ss");

        Timestamp t1=new Timestamp(System.currentTimeMillis());
        java.util.Date date1 = new java.util.Date(t1.getTime());

        Boolean p=new Boolean("true");
        List<CheckInOutDetails> d=checkInCheckOutDAO.getdate(empId);
        for(CheckInOutDetails c: d){
            System.out.println(c.getEmpId()+" "+c.getDate()+" "+c.getStart_time());
        }

        for(CheckInOutDetails c: d){

            if(c.getEmpId().equals(empId) && c.getDate().equals(sqldate.toString())) {

                    if (c.getStart_time().compareTo(now.format(df)) > 0) {

                        checkInCheckOutDAO.updateCheckIn(empId);
                        p=false;

                        return true;
                    } else {

                        return false;
                    }


            }

        }
        if(p)
        {
            checkInCheckOutDAO.setCheckIn(empId);
            System.out.println("In service add checkin");
            return true;
        }

        return true;



    }

    @Override
    public boolean addCheckOut(long empId) {
        java.util.Date date=new java.util.Date();
        java.sql.Date sqldate= new java.sql.Date(date.getTime());

                checkInCheckOutDAO.setCheckOut(empId,sqldate);
                return true;

    }
}
