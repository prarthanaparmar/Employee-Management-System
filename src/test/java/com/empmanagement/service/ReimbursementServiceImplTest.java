package com.empmanagement.service;

import com.empmanagement.dao.IAuthenticationDAO;
import com.empmanagement.dao.IReimbursementDao;
import com.empmanagement.daoimpl.AuthenticationDAOImpl;
import com.empmanagement.daoimpl.ReimbursementDaoImpl;
import com.empmanagement.domain.ReimbursementDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.empmanagement.serviceimpl.ReimbursementServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ReimbursementServiceImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private ReimbursementDaoImpl reimbDao;

    @Mock
    private ReimbursementDetails reimbDetails;


    @InjectMocks
    ReimbursementServiceImpl reimbService;

    private static final Long EMPID = (long) 11102;
    private static final int REIMBAMOUNT = 200;
    private static final String SUCCESS = "success";
    private static final String GRADE = "A";
    private static final int BASICSALARY = 1000;
    private static final String STATUS = "active";
    private static final int UPDATEREIM = 100;
    private static final String ERROR = "error";

    @Test
    void validityTest() {
        IReimbursementService reimbService = new ReimbursementServiceImpl();
        assertTrue(reimbService.validity(300,12));
    }

    @Test
    void saveAppliedReimbursementTest(){
        Mockito.when(reimbDao.updateApprovedAllowance(EMPID,REIMBAMOUNT)).thenReturn(SUCCESS);
        String expectedValue = ERROR;
        String status = reimbService.saveAppliedReimbursement(EMPID, (long) REIMBAMOUNT);
        assertFalse(expectedValue == status);
    }
}