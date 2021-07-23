package com.empmanagement.service;

public interface IAuthenticationService {
	public boolean validatePassword(String userName, String password);
	public String updatePassword(Long empId, String password);
	public Long getEmpID(String userName);
}
