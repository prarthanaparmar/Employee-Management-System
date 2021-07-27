package com.empmanagement.serviceimpl;

import com.empmanagement.dao.IManagerReviewDAO;
import com.empmanagement.dao.IReviewsDAO;
import com.empmanagement.domain.ManagerEmployeeRelation;
import com.empmanagement.domain.ManagerReviewForm;
import com.empmanagement.service.IManangerReviewsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class ManagerReviewsServiceImpl implements IManangerReviewsService {
    @Autowired
    IManagerReviewDAO managerReviewDAO;
    @Autowired
    IReviewsDAO reviews;

    public List<ManagerEmployeeRelation> getManagers(String empId){
        List<ManagerEmployeeRelation> managerEmployeeRelations=managerReviewDAO.getManagers(empId);
        return managerEmployeeRelations;
    }

    public boolean checkManagerInput(ManagerReviewForm managerReviewForm){
        if(managerReviewForm.getManagers().length()==0){
            return false;
        }
        return true;
    }

    public boolean checkManagerGeneralInput(ManagerReviewForm managerReviewForm){
        String sScore=managerReviewForm.getSkillsScore();
        String cScore=managerReviewForm.getCommunicationScore();
        String lScore=managerReviewForm.getLeadershipScore();
        String oScore=managerReviewForm.getOtherScore();

        // Regex to check string
        // contains only digits
        String regex = "^[0-9]*\\.?[0-9]+$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        if(!p.matcher(cScore).matches() || !p.matcher(sScore).matches() || !p.matcher(lScore).matches() || !p.matcher(oScore).matches()){
            return false;
        }
        else if(Double.parseDouble(sScore)<0 || Double.parseDouble(sScore)>10){
            return false;
        }
        else if(Double.parseDouble(cScore)<0 || Double.parseDouble(cScore)>10){
            return false;
        }
        else if(Double.parseDouble(lScore)<0 || Double.parseDouble(lScore)>10){
            return false;
        }
        else if(Double.parseDouble(oScore)<0 || Double.parseDouble(oScore)>10){
            return false;
        }
        else{
            return true;
        }

    }

    public String saveManagerReview(String empId1,ManagerReviewForm managerReviewForm){
        String empId2=managerReviewForm.getManagers().split(" ")[0];
        String sScore=managerReviewForm.getSkillsScore();
        String cScore=managerReviewForm.getCommunicationScore();
        String lScore=managerReviewForm.getLeadershipScore();
        String oScore=managerReviewForm.getOtherScore();

        Date todayDate = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(todayDate);

        String output=reviews.saveReview(Integer.valueOf(empId1),Integer.valueOf(empId2),sScore,cScore,lScore,oScore,date);
        return output;
    }
}
