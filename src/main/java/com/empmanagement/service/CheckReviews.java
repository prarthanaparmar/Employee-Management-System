package com.empmanagement.service;

import com.empmanagement.dao.IReviewsDAO;
import com.empmanagement.domain.EmployeeReviewForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

@Service
public class CheckReviews implements ICheckReviews{
    @Autowired
    IReviewsDAO reviews;

    public boolean checkInput(EmployeeReviewForm managerReviewForm){
        if(managerReviewForm.getPeers().length()==0){
            return false;
        }
        return true;
    }

    public boolean checkGeneralInput(EmployeeReviewForm managerReviewForm){
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

    public String saveReview(String empId1,EmployeeReviewForm managerReviewForm){
        String empId2=managerReviewForm.getPeers().split(" ")[0];
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
