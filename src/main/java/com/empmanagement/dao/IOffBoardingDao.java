package com.empmanagement.dao;

import java.sql.Date;
/**
 * Interface for Offboarding DAO
 * @author Prarthanaben Parmar
 */

public interface IOffBoardingDao {
	
	Date getDateOfJoin(Long empId);
	String getEMail(Long empId);
	String offBoardEmp(Long empId);
	String disableUser(Long empId); 
}
