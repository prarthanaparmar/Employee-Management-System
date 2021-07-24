package com.empmanagement.dao;

import com.empmanagement.domain.EmployeePeer;
import com.empmanagement.domain.EmployeePeerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PeerReviewDAOImpl implements IPeerReviewDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EmployeePeer> getPeers(String empId){
        String sql="select t.empId,t.empName from (select * from employee e where e.empId="+empId+") as u inner join (select * from employee emp) as t on u.team=t.team and t.empId!="+empId;
        List<EmployeePeer> performanceManagements= jdbcTemplate.query(sql, new EmployeePeerRowMapper());
        return performanceManagements;
    }
}
