package com.empmanagement.dao;

public interface ManagerDAO {

    /*
     * Gets the employeeID from database for the employee
     */
    public String getApraisalDetailsFromDatabase(Integer empId);
    public Long getManagerEmpIDFromDatabase(String deptName);

}
