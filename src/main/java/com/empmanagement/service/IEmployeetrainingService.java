package com.empmanagement.service;

import com.empmanagement.domain.EmployeetrainingDetails;
import com.empmanagement.domain.TimeSheetDetail;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public interface IEmployeetrainingService {
    //public List<EmployeetrainingDetails> getTrainingDetails(Long type);
    public List<EmployeetrainingDetails> getMandatoryTraining(Long empId);
    List<EmployeetrainingDetails> search(String keyword);
}
