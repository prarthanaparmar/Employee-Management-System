package com.empmanagement.dao;

import com.empmanagement.domain.EmployeePeer;
import com.empmanagement.domain.EmployeePeerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public class ManagerReviewDAOImpl implements IManagerReviewDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EmployeePeer> getManagers(String empId){
        String sql="Select s.managerId as empId,u.empName from (select * from teams t inner join employee e on t.teams=e.team where e.empId="+empId+") as s inner join (select * from employee emp) as u on s.managerId=u.empId";
        List<EmployeePeer> managers= jdbcTemplate.query(sql, new EmployeePeerRowMapper());
        return managers;
    }
}
