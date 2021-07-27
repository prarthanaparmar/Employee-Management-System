package com.empmanagement.serviceimpl;

import com.empmanagement.dao.ICheckInCheckOutDAO;
import com.empmanagement.domain.CheckInOutDetails;
import com.empmanagement.domain.TimeSheetDetail;
import com.empmanagement.service.ICheckInOutService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ICheckInOutServiceImpl implements ICheckInOutService {

    @Autowired
    ICheckInCheckOutDAO checkInCheckOutDAO;



    @Override
    public boolean addCheckIn(long empId) {


        //List<CheckInOutDetails> timesheet= checkInCheckOutDAO.getTimeSheetDetail(empId);

        java.util.Date date=new java.util.Date();
        java.sql.Date sqldate= new java.sql.Date(date.getTime());

        Timestamp t1=new Timestamp(System.currentTimeMillis());
        java.util.Date localtime = new java.util.Date(t1.getTime());


         //if(checkInCheckOutDAO.getstarttime(empId).compareTo(localtime)>0)
        //{

                    //checkInCheckOutDAO.updateCheckIn(empId);
                    //System.out.println("In service update checkin");
                    //return true;


        checkInCheckOutDAO.setCheckIn(empId);
        System.out.println("In service add checkin");
        return true;

        //}
        //else
          //return false;

    }

    @Override
    public boolean addCheckOut(long empId) {
        java.util.Date date=new java.util.Date();
        java.sql.Date sqldate= new java.sql.Date(date.getTime());

        //Timestamp t1=new Timestamp(System.currentTimeMillis());
        //java.util.Date localtime = new java.util.Date(t1.getTime());


                checkInCheckOutDAO.setCheckOut(empId,sqldate);
                return true;

    }
}
