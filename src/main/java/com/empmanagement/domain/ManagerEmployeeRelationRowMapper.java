package com.empmanagement.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerEmployeeRelationRowMapper implements RowMapper<ManagerEmployeeRelation> {

    @Override
    public ManagerEmployeeRelation mapRow(ResultSet rs, int rowNum) throws SQLException {
        ManagerEmployeeRelation managerEmployeeRelation=new ManagerEmployeeRelation();

        managerEmployeeRelation.setManagerId(rs.getString("managerId"));
        managerEmployeeRelation.setEmpName(rs.getString("empName"));

        return managerEmployeeRelation;
    }
}
