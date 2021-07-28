package com.empmanagement.serviceimpl;

import com.empmanagement.dao.IEmployeetrainingDAO;
import com.empmanagement.domain.EmployeetrainingDetails;
import com.empmanagement.service.IEmployeetrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class EmployeetrainingServiceImpl implements IEmployeetrainingService {

    @Autowired
    IEmployeetrainingDAO employeetrainingDAO;

    public List<EmployeetrainingDetails> getTrainingDetails(Long type) {

            List<EmployeetrainingDetails> td = employeetrainingDAO.getTrainings(type);
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            return td;

        }

    @Override
    public List<EmployeetrainingDetails> getMandatoryTraining(Long empId) {

        List<EmployeetrainingDetails> td = employeetrainingDAO.getCompeletedTraining(empId);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        if(td.size()!=0) {
            for (EmployeetrainingDetails t : td) {

                t.setCoursename(t.getCoursename());
            }
            return td;
        }
        else{
            return null;
        }
    }

    @Override
    public List<EmployeetrainingDetails> search(String keyword){
        List<EmployeetrainingDetails> sr=employeetrainingDAO.search(keyword);
        return sr;
    }

}
