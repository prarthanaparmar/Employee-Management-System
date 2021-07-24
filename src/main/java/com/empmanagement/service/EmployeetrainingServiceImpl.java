package com.empmanagement.service;

import com.empmanagement.dao.IEmployeetrainingDAO;
import com.empmanagement.domain.EmployeetrainingDetails;
import com.empmanagement.domain.EmployeetrainingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class EmployeetrainingServiceImpl implements IEmployeetrainingService {

    @Autowired
    IEmployeetrainingDAO employeetrainingDAO;

    //@Override
    public List<EmployeetrainingDetails> getTrainingDetails(Long type) {

            List<EmployeetrainingDetails> td = employeetrainingDAO.getTrainings(type);
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            return td;

        }
        //return td;

    @Override
    public List<EmployeetrainingDetails> getMandatoryTraining(Long empId) {

        List<EmployeetrainingDetails> td = employeetrainingDAO.getCompeletedTraining(empId);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        if(td.size()!=0) {
            for (EmployeetrainingDetails t : td) {
                //t.setHours_worked(getHours(getTimeDifference(format.parse(t.getStart_time()), format.parse(t.getEnd_time()))));
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
