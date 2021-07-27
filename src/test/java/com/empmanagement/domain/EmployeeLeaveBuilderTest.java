package com.empmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class EmployeeLeaveBuilderTest {
    @Test
    void setLeaveType() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);  
        LocalDate endDt = LocalDate.of(2021, 7, 17);  
        LocalDate applyDt = LocalDate.of(2021, 7, 1);  
        LocalDate approveDt = LocalDate.of(2021, 7, 10);  
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);  

        EmployeeLeave tt = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt, "bbb");
        EmployeeLeaveBuilder t = new EmployeeLeaveBuilder(tt);
        assertEquals(t, t.setLeaveType("aaa"));
    }

    @Test
    void setStartDt() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);  
        LocalDate endDt = LocalDate.of(2021, 7, 17);  
        LocalDate applyDt = LocalDate.of(2021, 7, 1);  
        LocalDate approveDt = LocalDate.of(2021, 7, 10);  
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);  

        EmployeeLeave tt = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt, "bbb");
        EmployeeLeaveBuilder t = new EmployeeLeaveBuilder(tt);
        assertEquals(t, t.setStartDt(startDt));
    }

    @Test
    void setEndDt() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);  
        LocalDate endDt = LocalDate.of(2021, 7, 17);  
        LocalDate applyDt = LocalDate.of(2021, 7, 1);  
        LocalDate approveDt = LocalDate.of(2021, 7, 10);  
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);  

        EmployeeLeave tt = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt, "bbb");
        EmployeeLeaveBuilder t = new EmployeeLeaveBuilder(tt);
        assertEquals(t, t.setEndDt(endDt));
    }

    @Test
    void setApplyDt() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);  
        LocalDate endDt = LocalDate.of(2021, 7, 17);  
        LocalDate applyDt = LocalDate.of(2021, 7, 1);  
        LocalDate approveDt = LocalDate.of(2021, 7, 10);  
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);  

        EmployeeLeave tt = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt, "bbb");
        EmployeeLeaveBuilder t = new EmployeeLeaveBuilder(tt);
        assertEquals(t, t.setApplyDt(applyDt));
    }

    @Test
    void setApproveDt() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);  
        LocalDate endDt = LocalDate.of(2021, 7, 17);  
        LocalDate applyDt = LocalDate.of(2021, 7, 1);  
        LocalDate approveDt = LocalDate.of(2021, 7, 10);  
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);  

        EmployeeLeave tt = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt, "bbb");
        EmployeeLeaveBuilder t = new EmployeeLeaveBuilder(tt);
        assertEquals(t, t.setApproveDt(approveDt));
    }

    @Test
    void setEmpId() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);  
        LocalDate endDt = LocalDate.of(2021, 7, 17);  
        LocalDate applyDt = LocalDate.of(2021, 7, 1);  
        LocalDate approveDt = LocalDate.of(2021, 7, 10);  
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);  

        EmployeeLeave tt = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt, "bbb");
        EmployeeLeaveBuilder t = new EmployeeLeaveBuilder(tt);
        assertEquals(t, t.setEmpId(12345678910L));
    }

    @Test
    void setLeaveId() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);  
        LocalDate endDt = LocalDate.of(2021, 7, 17);  
        LocalDate applyDt = LocalDate.of(2021, 7, 1);  
        LocalDate approveDt = LocalDate.of(2021, 7, 10);  
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);  

        EmployeeLeave tt = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt, "bbb");
        EmployeeLeaveBuilder t = new EmployeeLeaveBuilder(tt);
        assertEquals(t, t.setLeaveId(1));
    }

    @Test
    void setComment() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);  
        LocalDate endDt = LocalDate.of(2021, 7, 17);  
        LocalDate applyDt = LocalDate.of(2021, 7, 1);  
        LocalDate approveDt = LocalDate.of(2021, 7, 10);  
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);  

        EmployeeLeave tt = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt, "bbb");
        EmployeeLeaveBuilder t = new EmployeeLeaveBuilder(tt);
        assertEquals(t, t.setComment("bbb"));
    }

    @Test
    void setCancelDt() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);  
        LocalDate endDt = LocalDate.of(2021, 7, 17);  
        LocalDate applyDt = LocalDate.of(2021, 7, 1);  
        LocalDate approveDt = LocalDate.of(2021, 7, 10);  
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);  

        EmployeeLeave tt = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt, "bbb");
        EmployeeLeaveBuilder t = new EmployeeLeaveBuilder(tt);
        assertEquals(t, t.setCancelDt(cancelDt));
    }

    @Test
    void isValid() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);  
        LocalDate endDt = LocalDate.of(2021, 7, 17);  
        LocalDate applyDt = LocalDate.of(2021, 7, 1);  
        LocalDate approveDt = LocalDate.of(2021, 7, 10);  
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);  

        EmployeeLeave tt = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt, "bbb");
        EmployeeLeaveBuilder t = new EmployeeLeaveBuilder(tt);
        assertTrue(t.isValid());
    }

    @Test
    void build() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);  
        LocalDate endDt = LocalDate.of(2021, 7, 17);  
        LocalDate applyDt = LocalDate.of(2021, 7, 1);  
        LocalDate approveDt = LocalDate.of(2021, 7, 10);  
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);  

        EmployeeLeave tt = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt, "bbb");
        EmployeeLeaveBuilder t = new EmployeeLeaveBuilder(tt);
        assertEquals(tt, t.build());
    }
}
