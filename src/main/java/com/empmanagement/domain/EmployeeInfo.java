package com.empmanagement.domain;

/**
 * @author Neel Patel
 */
public class EmployeeInfo {

    private long empId;
    private String name;
    private String email;
    private String role;
    private String dept;

    public EmployeeInfo(long empId, String name, String email, String role, String dept) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.role = role;
        this.dept = dept;
    }

    /**
     * @return employee id
     */
    public long getEmpId(){
        return this.empId;
    }

    /**
     * @return employee name
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * @return employee email
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * @return employee role
     */
    public String getRole(){
        return this.role;
    }

    /**
     * @return employee department
     */
    public String getDept(){
        return this.dept;
    }
}
