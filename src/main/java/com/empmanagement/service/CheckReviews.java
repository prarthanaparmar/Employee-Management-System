package com.empmanagement.service;

import com.empmanagement.dao.IReviewsDAO;
import com.empmanagement.domain.EmployeeReviewForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/*
 * @author: Dhruv Bharatbhai Patel - B00868931
 * @description: This class will be responsible for implementing business logic related to reviews.
 * */
@Service
public class CheckReviews implements ICheckReviews{
    @Autowired
    IReviewsDAO reviewsDAO;

    /*
    * Method to check the correct input received from user.
    *
    * @param managerReviewForm Model object
    * @returns true or false depending on the input
    * */
    public boolean checkInput(EmployeeReviewForm managerReviewForm){
        if(managerReviewForm.getPeers().length()==0){
            return false;
        }
        return true;
    }

    /*
    * Method to check the input from user is double value between 0 to 10.
    *
    * @param managerReviewForm Model object
    * @returns true or false depending on the input
    * */
    public boolean checkGeneralInput(EmployeeReviewForm managerReviewForm){
        String skillsScore=managerReviewForm.getSkillsScore();
        String communicationScore=managerReviewForm.getCommunicationScore();
        String leadershipScore=managerReviewForm.getLeadershipScore();
        String otherScore=managerReviewForm.getOtherScore();

        // Regex to check string
        // contains only digits
        String regex = "^[0-9]*\\.?[0-9]+$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If else to check validity of scores
        if(!p.matcher(communicationScore).matches() || !p.matcher(skillsScore).matches() || !p.matcher(leadershipScore).matches() || !p.matcher(otherScore).matches()){
            return false;
        }
        else if(Double.parseDouble(skillsScore)<0 || Double.parseDouble(skillsScore)>10){
            return false;
        }
        else if(Double.parseDouble(communicationScore)<0 || Double.parseDouble(communicationScore)>10){
            return false;
        }
        else if(Double.parseDouble(leadershipScore)<0 || Double.parseDouble(leadershipScore)>10){
            return false;
        }
        else if(Double.parseDouble(otherScore)<0 || Double.parseDouble(otherScore)>10){
            return false;
        }
        else{
            return true;
        }

    }

    /*
    * Method to save the review for an employee
    *
    * @param managerReviewForm Model object
    * @returns success or failure as string message
    * */
    public String saveReview(String empId1,EmployeeReviewForm managerReviewForm){
        String empId2=managerReviewForm.getPeers().split(" ")[0];
        String skillsScore=managerReviewForm.getSkillsScore();
        String communicationScore=managerReviewForm.getCommunicationScore();
        String leadershipScore=managerReviewForm.getLeadershipScore();
        String otherScore=managerReviewForm.getOtherScore();

        // Get the current date in YYYY-MM-DD format
        Date todayDate = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(todayDate);

        return reviewsDAO.saveReview(Integer.parseInt(empId1),Integer.parseInt(empId2),skillsScore,communicationScore,leadershipScore,otherScore,date);
    }
}
