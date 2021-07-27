package com.empmanagement.serviceimpl;

import com.empmanagement.service.IEmpRegService;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Prarthanaben Parmar
 *
 */

class EmpRegServiceImplTest {

    @Test
    void getDeptIdTest() {

        IEmpRegService empReg = new EmpRegServiceImpl();
        int deptId = empReg.getDeptId("IT");
        assertTrue(deptId == 35);
    }

    @Test
    void generateEmailTest() {

        IEmpRegService empReg = new EmpRegServiceImpl();
        String email = empReg.generateEmail("Prarthana", "Parmar");
        String regex = "PrarthanaParmar"+"[0-9]+"+"@orgdomain.com";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        assertTrue(matcher.matches());
    }

    @Test
    void getFullNameTest() {

        IEmpRegService empReg = new EmpRegServiceImpl();
        String name = empReg.getFullName("Prarthana", "Parmar");
        assertTrue(name.equals("Prarthana Parmar"));
    }

    @Test
    void getEmpUserNameTestTest() {

        IEmpRegService empReg = new EmpRegServiceImpl();
        int i = 0;
        String username = empReg.getEmpUserName("Prarthana", "Parmar");
        String regex = "PrarthanaParmar"+"[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        assertTrue(matcher.matches());
    }

    @Test
    void getPasswordTest() throws NoSuchAlgorithmException {

        IEmpRegService empReg = new EmpRegServiceImpl();
        String pass = empReg.getPassword();
        assertFalse(pass.equals(null));
    }
}
