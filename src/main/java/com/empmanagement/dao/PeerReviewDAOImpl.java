package com.empmanagement.dao;

import com.empmanagement.domain.EmployeePeer;
import com.empmanagement.domain.EmployeePeerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This DAO(Data access Object) class communicates to database to perform CRUD operation related to peer reviews.
 * */
@Repository
public class PeerReviewDAOImpl implements IPeerReviewDAO {
    private static final String TABLE_EMPLOYEES="employee";
    private static final String QUERY_GET_MANAGERS_PART="select t.empId,t.empName from (select * from "+TABLE_EMPLOYEES+" e where e.empId= ? ) as u inner join (select * from "+TABLE_EMPLOYEES+" emp) as t on u.team=t.team and t.empId! = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*
    * This method gets the list of peers from database
    *
    * @param empId Employee Id of an employee
    * @returns List of EmployeePeer or null
    * */
    public List<EmployeePeer> getPeers(String empId){
        try {
            String sql = QUERY_GET_MANAGERS_PART;
            List<EmployeePeer> performanceManagements = jdbcTemplate.query(sql, new Object[]{empId, empId}, new EmployeePeerRowMapper());
            return performanceManagements;
        }
        catch(Exception exception){
            System.out.println("Exception occured at while fetching peers: "+ exception.getMessage());
            return null;
        }
    }
}
