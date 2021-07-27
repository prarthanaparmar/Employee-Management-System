package com.empmanagement.dao;

import com.empmanagement.domain.EmployeetrainingDetails;
import com.empmanagement.domain.TimeSheetDetail;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IEmployeetrainingDAO {

    List<EmployeetrainingDetails> getTrainings(Long empId);
    List<EmployeetrainingDetails> getCompeletedTraining(Long empId);
    //List<EmployeetrainingDetails> getPendingTraining(Long empId);
    List<EmployeetrainingDetails> search(String keyword);
}
