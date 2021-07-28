package com.empmanagement.service;

import com.empmanagement.dao.IAuthenticationDAO;
import com.empmanagement.dao.IEmpregisterDAO;
import com.empmanagement.serviceimpl.AuthenticationServiceImpl;
import org.junit.jupiter.api.Test;

import com.empmanagement.serviceimpl.EmpRegServiceImpl;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmpRegServiceImplTest {

    @Mock
    private IEmpregisterDAO empregDao;

    @InjectMocks
    EmpRegServiceImpl empregservice;

    private final static int FALSEDEPTID = 16;
    private final static String DEPTNAME = "IT";
    private final static int DEPTID = 15;
    private final static String NAME = "Prarthana";
    private final static String EMAIL = "psp@gmail.com";
    private final static Date DOJ =  new Date(2016-07-06);
    private final static Date DOB = new Date(1997-05-01);
    private final static String ROLE = "developer";
    private final static String GRADE = "A";
    private final static String TEAM = "QA";
    private final static String STATUS = "active";
    private final static String PERSONALEMAIL = "pswps@gmail.com";
    private final static String SUCCESS = "success";
    private final static String ERROR = "error";
    private final static Long TRUEEMPID = Long.valueOf(1505);
    private final static Long FALSEEMPID = Long.valueOf(1508);
    private final static String USERNAME = "PrathanaParmar";
    private final static String PASSWORD = "password";
    @Test
    void registerEmployeeTest(){
        Mockito.when(empregDao.registerEmp(NAME,EMAIL,DOJ,DOB,ROLE,GRADE,DEPTID,TEAM,STATUS,PERSONALEMAIL)).thenReturn(SUCCESS);
        String actualString = SUCCESS;
        String returnedString = empregservice.registerEmp(NAME,EMAIL,DOJ,DOB,ROLE,GRADE,DEPTID,TEAM,STATUS,PERSONALEMAIL);
        assertTrue(actualString==returnedString);

    }

    @Test
    void getDeptIdTestPass() {
        Mockito.when(empregDao.getDeptId(DEPTNAME)).thenReturn(DEPTID);
        int actualDeptId = DEPTID;
        int returnedId = empregservice.getDeptId(DEPTNAME);
        assertTrue(returnedId == actualDeptId);
    }

    @Test
    void getDeptIDTestFail(){
        Mockito.when(empregDao.getDeptId(DEPTNAME)).thenReturn(DEPTID);
        int actualDeptId = FALSEDEPTID;
        int returnedId = empregservice.getDeptId(DEPTNAME);
        assertFalse(returnedId == actualDeptId);
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
    void getEmpUserNameTest() {

        IEmpRegService empReg = new EmpRegServiceImpl();
        int i = 0;
        String username = empReg.getEmpUserName("Prarthana", "Parmar");
        String regex = "PrarthanaParmar"+"[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        assertTrue(matcher.matches());
    }

    @Test
    void getEmpIDTestPass(){
        Mockito.when(empregDao.getEmpId(NAME,DOB)).thenReturn(TRUEEMPID);
        Long actualEmpId = TRUEEMPID;
        assertTrue(actualEmpId == empregservice.getEmpId(NAME,DOB));
    }

    @Test
    void getEmpIDTestFail(){
        Mockito.when(empregDao.getEmpId(NAME,DOB)).thenReturn(FALSEEMPID);
        Long actualEmpId = TRUEEMPID;
        assertFalse(actualEmpId == empregservice.getEmpId(NAME,DOB));
    }

    @Test
    void updateLoginTest(){
        Mockito.when(empregDao.loginDetails(USERNAME,PASSWORD,TRUEEMPID)).thenReturn(SUCCESS);
        String actualString = SUCCESS;
        String returnedString = empregservice.updateLogin(USERNAME,PASSWORD,TRUEEMPID);
        assertTrue(actualString==returnedString);

    }

    @Test
    void getUSerNameTest(){
        Mockito.when(empregDao.getUsername(TRUEEMPID)).thenReturn(USERNAME);
        String actualUserName = USERNAME;
        assertTrue(actualUserName == empregservice.getUsername(TRUEEMPID));
    }
}