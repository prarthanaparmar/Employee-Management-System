package com.empmanagement.dao;

public interface ManagerDAO {

    /*
     * Gets the employeeID from database for the employee
     */
    //public String getPasswordFromDatabase(String userName);
    public Long getEmpIDFromDatabase(String userName);

}
