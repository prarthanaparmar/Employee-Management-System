package com.empmanagement.daoimpl;

import com.empmanagement.dao.IEmployeetrainingDAO;
import com.empmanagement.domain.EmployeetrainingDetails;
import com.empmanagement.domain.EmployeetrainingRowMapper;
import com.empmanagement.domain.TimeSheetDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

@Repository
public class EmployeetrainingDAOImpl implements IEmployeetrainingDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EmployeetrainingDetails employeetrainingDetailsDetail;

    @Override
    public List<EmployeetrainingDetails> getTrainings(Long empId) {

        String sql="Select * from employee_training where empId="+empId+"";
        List<EmployeetrainingDetails> trainings= jdbcTemplate.query(sql, new EmployeetrainingRowMapper());
        return trainings;
       // return null;
    }

    @Override
    public List<EmployeetrainingDetails> getCompeletedTraining(Long empId) {

        String sql="Select * from employee_training_tracking where empId="+empId+"";
        List<EmployeetrainingDetails> trainings= jdbcTemplate.query(sql, new EmployeetrainingRowMapper());
        return trainings;
    }



    @Override
    public List<EmployeetrainingDetails> search(String keyword)
    {
        String sql="select * from CSCI5308_10_DEVINT.employee_training where courseId like '%"+keyword+"%' or course_name like '%"+keyword+"%';";
        List<EmployeetrainingDetails> trainings= jdbcTemplate.query(sql, new EmployeetrainingRowMapper());
        return trainings;
    }
}
