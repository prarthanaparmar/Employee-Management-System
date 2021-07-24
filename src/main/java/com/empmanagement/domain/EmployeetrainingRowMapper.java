package com.empmanagement.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeetrainingRowMapper implements RowMapper<EmployeetrainingDetails> {

    @Override
    public EmployeetrainingDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeetrainingDetails trainingDetail = new EmployeetrainingDetails();

        trainingDetail.setCourseId(rs.getString("courseId"));
        trainingDetail.setCoursename(rs.getString("coursename"));
        trainingDetail.setCoursetype(rs.getString("coursetype"));
        trainingDetail.setCertification(rs.getString("certification"));


        return trainingDetail;
    }

}