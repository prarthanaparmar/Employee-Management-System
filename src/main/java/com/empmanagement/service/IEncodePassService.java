package com.empmanagement.service;

import java.security.NoSuchAlgorithmException;

public interface IEncodePassService {

	String encodePassword(String password) throws NoSuchAlgorithmException;
}
