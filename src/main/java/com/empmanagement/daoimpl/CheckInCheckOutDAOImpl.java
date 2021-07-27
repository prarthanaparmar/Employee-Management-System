package com.empmanagement.daoimpl;

import com.empmanagement.dao.ICheckInCheckOutDAO;
import com.empmanagement.domain.CheckInOutDetails;
import com.empmanagement.domain.CheckInOutRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceSchemaCreatedEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


import java.util.List;

@Repository
public class CheckInCheckOutDAOImpl implements ICheckInCheckOutDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //@Autowired
    Date date =new Date();
    Timestamp t1=new Timestamp(System.currentTimeMillis());
    Date date1 = new Date(t1.getTime());
            java.sql.Date sqltime= new java.sql.Date(date.getTime());
    java.sql.Date sqldate= new java.sql.Date(date.getTime());
    /*java.util.Date d1=new java.util.Date();
    java.sql.Date d2=new java.sql.Date(d1.getTime());
    java.sql.Time d3=new java.sql.Date(Calender.getInstance().getTime().getTime());
    Calender calender=Calender.getInstance();
    Timestamp t1=new Timestamp(new Date().getTime());*/


    Long empId;

    @Override
    public void setCheckIn(Long empId) {
        String sql="Insert into timesheet_employee(empId,date,day,start_time,end_time) values(?,?,?,?,?)";
        jdbcTemplate.update(sql,empId,sqldate,sayDay(sqldate),date1,"00:00:00");
        System.out.println("In DAO SetcheckIn");
    }

    @Override
    public void updateCheckIn(Long empId) {
        String sql="Update timesheet_employee set start_time=? && date=? where empId=?";
        jdbcTemplate.update(sql,date1,sqldate,empId);
        //jdbcTemplate.update(sql,11,sqldate,sayDay(sqldate),date1,"00:00:00");
        System.out.println("In DAO SetcheckIn");
    }

    public String sayDay(Date d)
    {
        DateFormat df=new SimpleDateFormat("EEEE");
        try
        {
            return df.format(d);
        }catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public void setCheckOut(Long empId,Date date) {
        String sql="Update timesheet_employee set end_time=? where empId=? && date=?";
        jdbcTemplate.update(sql,date1,empId,sqldate);
        System.out.println("In DAO Setcheckout");
    }

    @Override
    public List<CheckInOutDetails> getdate(Long empId)
    {

        String sql="Select date from timesheet_employee t where t.empId ="+empId+" ";
        List<CheckInOutDetails> d=jdbcTemplate.query(sql, new CheckInOutRowMapper());

        return d;
    }

    @Override
    public Time getendtime(Long empId) {

        String sql="Select end_time from timesheet_employee t where t.empId ="+empId+ " and t.date<=localtime()";
        Time endtime= (Time) jdbcTemplate.queryForObject(sql,Time.class);
        return endtime;
    }

    @Override
    public Time getstarttime(Long empId) {

        String sql="Select Start_time from timesheet_employee t where t.empId ="+empId+ " and t.date<=localtime()";
        Time starttime= (Time) jdbcTemplate.queryForObject(sql,Time.class);
        return starttime;
    }

    @Override
    public List<CheckInOutDetails> getTimeSheetDetail(Long empId) {

        String sql="Select * from timesheet_employee t where t.empId ="+empId+ " and t.date<=localtime()";
        List<CheckInOutDetails> timeSheet= jdbcTemplate.query(sql, new CheckInOutRowMapper());
        return timeSheet;
    }
    /*public List<Long> getEmpID(Stri userName) {

        try {

            empId = jdbcTemplate.queryForObject("select empId from timesheet_employee where",
                    Long.class, userName);

        } catch (Exception e) {

            System.err.println(e);
        }

        return empId;
    }*/
}
