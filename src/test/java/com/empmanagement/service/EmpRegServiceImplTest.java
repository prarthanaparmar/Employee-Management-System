package com.empmanagement.service;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class EmpRegServiceImplTest {

    @Test
    void getDeptId() {

        IEmpRegService empReg = new EmpRegServiceImpl();
        int deptId = empReg.getDeptId("IT");
        assertTrue(deptId==35);
    }

    @Test
    void generateEmail() {

        IEmpRegService empReg = new EmpRegServiceImpl();
        int i = 0;
        String username = empReg.generateEmail("Prarthana","Parmar");
        String split[] = username.split("PrarthanaParmar");
        char[] chars = split[1].toCharArray();
        for(char c : chars){
            if(Character.isDigit(c)){
                i++;
            }
        }
        boolean value = split[1].contains("@orgdomain.com");
        assertTrue(i>0&&value);

    }

    @Test
    void getFullName() {

        IEmpRegService empReg = new EmpRegServiceImpl();
        String name = empReg.getFullName("Prarthana" , "Parmar");
        assertTrue(name.equals("Prarthana Parmar"));
    }

    @Test
    void getEmpUserNameTest() {

        IEmpRegService empReg = new EmpRegServiceImpl();
        int i = 0;
        String username = empReg.getEmpUserName("Prarthana","Parmar");
        String split[] = username.split("PrarthanaParmar");
        char[] chars = split[1].toCharArray();
        for(char c : chars){
            if(Character.isDigit(c)){
                i++;
            }
        }
        assertTrue(i>0);
    }

    @Test
    void getPasswordTest() throws NoSuchAlgorithmException {

        IEmpRegService empReg = new EmpRegServiceImpl();
        String pass = empReg.getPassword();
        assertFalse(pass.equals(null));
    }
}