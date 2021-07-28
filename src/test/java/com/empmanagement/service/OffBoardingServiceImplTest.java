package com.empmanagement.service;

import com.empmanagement.dao.IEmpregisterDAO;
import com.empmanagement.dao.IOffBoardingDao;
import com.empmanagement.daoimpl.OffBoardingDaoImpl;
import com.empmanagement.serviceimpl.OffBoardingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class OffBoardingServiceImplTest {
    @Mock
    private IOffBoardingDao offBoardDao;

    @InjectMocks
    OffBoardingServiceImpl offboardservice;

    private final static Long EMPID = Long.valueOf(1505);
    private final static Date DOJ = new Date(2016-03-05);
    private final static String SUCCESS = "success";
    private final static String EMAIL = "psp@gmail.com";

    @Test
    void offBoardEmp() {
        Mockito.when(offBoardDao.offBoardEmp(EMPID)).thenReturn(SUCCESS);
        String actualString = SUCCESS;
        String returned = offboardservice.offBoardEmp(EMPID);
        assertTrue( returned== SUCCESS);
    }

    @Test
    void disableUser() {
        Mockito.when(offBoardDao.disableUser(EMPID)).thenReturn(SUCCESS);
        String actualString = SUCCESS;
        String returned = offboardservice.offBoardEmp(EMPID);
        assertFalse(returned==SUCCESS);
    }

    @Test
    void getEMail() {
        Mockito.when(offBoardDao.getEMail(EMPID)).thenReturn(EMAIL);
        String actualEmail = EMAIL;
        String returnedEmail = offboardservice.getEMail(EMPID);
        assertTrue(actualEmail==returnedEmail);
    }
}