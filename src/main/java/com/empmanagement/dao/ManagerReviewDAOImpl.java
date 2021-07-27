package com.empmanagement.dao;

import com.empmanagement.domain.EmployeePeer;
import com.empmanagement.domain.EmployeePeerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This DAO(Data access Object) class communicates to database to perform CRUD operation related to manager reviews.
 * */
@Repository
    public class ManagerReviewDAOImpl implements IManagerReviewDAO {
    private static final String TABLE_EMPLOYEES="employee";
    private static final String TABLE_TEAMS="teams";
    private static final String QUERY_GET_MANAGERS_PART="SELECT s.managerId as empId,u.empName from (select * from "+ TABLE_TEAMS +" t inner join "+TABLE_EMPLOYEES+" e on t.teams=e.team where e.empId= ? ) as s inner join (select * from "+TABLE_EMPLOYEES+" emp) as u on s.managerId=u.empId";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*
    * This method gets the list of managers from database.
    *
    * @param empId Employee Id of employee
    * @returns List of EmployeePeer Model or null
    * */
    public List<EmployeePeer> getManagers(String empId){
        try {
            String sql = QUERY_GET_MANAGERS_PART;
            List<EmployeePeer> managers = jdbcTemplate.query(sql, new Object[]{empId}, new EmployeePeerRowMapper());
            return managers;
        }
        catch(Exception exception){
            System.out.println("Exception occured at while fetching managers: "+ exception.getMessage());
            return null;
        }
    }
}
