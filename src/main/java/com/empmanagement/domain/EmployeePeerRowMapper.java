package com.empmanagement.domain;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeePeerRowMapper implements RowMapper<EmployeePeer> {

    @Override
    public EmployeePeer mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeePeer employeePeer=new EmployeePeer();

        employeePeer.setEmpId(rs.getString("empId"));
        employeePeer.setEmpName(rs.getString("empName"));

        return employeePeer;
    }

}
