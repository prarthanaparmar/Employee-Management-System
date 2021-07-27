package com.empmanagement.domain;

import org.springframework.stereotype.Component;

@Component
public class EmployeetrainingDetails {

    public EmployeetrainingDetails() {
    }
    private String courseId,coursename,coursetype,certification,status,mandatory_training;


    public String getMandatory_training() {  return status; }

    public void setMandatory_training(String status){    this.status=status;   }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String coursetype() { return coursetype;  }

    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype;
    }

    public String getcertification() { return certification;  }

    public void setCertification(String certification) { this.certification=certification;  }

}
