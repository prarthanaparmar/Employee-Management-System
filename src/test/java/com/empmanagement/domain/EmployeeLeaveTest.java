package com.empmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * @author Neel Patel
 */
@DisplayName("Test suites for EmployeeLeave class")
public class EmployeeLeaveTest {

    @Test
    void getEmpId() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);
        LocalDate endDt = LocalDate.of(2021, 7, 17);
        LocalDate applyDt = LocalDate.of(2021, 7, 1);
        LocalDate approveDt = LocalDate.of(2021, 7, 10);
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);

        EmployeeLeave t = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt,
                "bbb");
        assertEquals(12345678910L, t.getEmpId());
    }

    @Test
    void getLeaveId() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);
        LocalDate endDt = LocalDate.of(2021, 7, 17);
        LocalDate applyDt = LocalDate.of(2021, 7, 1);
        LocalDate approveDt = LocalDate.of(2021, 7, 10);
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);

        EmployeeLeave t = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt,
                "bbb");
        assertEquals(1, t.getLeaveId());
    }

    @Test
    void getStartDt() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);
        LocalDate endDt = LocalDate.of(2021, 7, 17);
        LocalDate applyDt = LocalDate.of(2021, 7, 1);
        LocalDate approveDt = LocalDate.of(2021, 7, 10);
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);

        EmployeeLeave t = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt,
                "bbb");
        assertEquals(startDt, t.getStartDt());
    }

    @Test
    void getEndDt() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);
        LocalDate endDt = LocalDate.of(2021, 7, 17);
        LocalDate applyDt = LocalDate.of(2021, 7, 1);
        LocalDate approveDt = LocalDate.of(2021, 7, 10);
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);

        EmployeeLeave t = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt,
                "bbb");
        assertEquals(endDt, t.getEndDt());
    }

    @Test
    void getApplyDt() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);
        LocalDate endDt = LocalDate.of(2021, 7, 17);
        LocalDate applyDt = LocalDate.of(2021, 7, 1);
        LocalDate approveDt = LocalDate.of(2021, 7, 10);
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);

        EmployeeLeave t = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt,
                "bbb");
        assertEquals(applyDt, t.getApplyDt());
    }

    @Test
    void getApproveDt() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);
        LocalDate endDt = LocalDate.of(2021, 7, 17);
        LocalDate applyDt = LocalDate.of(2021, 7, 1);
        LocalDate approveDt = LocalDate.of(2021, 7, 10);
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);

        EmployeeLeave t = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt,
                "bbb");
        assertEquals(approveDt, t.getApproveDt());
    }

    @Test
    void getCancelDt() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);
        LocalDate endDt = LocalDate.of(2021, 7, 17);
        LocalDate applyDt = LocalDate.of(2021, 7, 1);
        LocalDate approveDt = LocalDate.of(2021, 7, 10);
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);

        EmployeeLeave t = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt,
                "bbb");
        assertEquals(cancelDt, t.getCancelDt());
    }

    @Test
    void isTaken() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);
        LocalDate endDt = LocalDate.of(2021, 7, 17);
        LocalDate applyDt = LocalDate.of(2021, 7, 1);
        LocalDate approveDt = LocalDate.of(2021, 7, 10);
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);

        EmployeeLeave t = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt,
                "bbb");
        assertTrue(t.isTaken());
    }

    @Test
    void isApproved() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);
        LocalDate endDt = LocalDate.of(2021, 7, 17);
        LocalDate applyDt = LocalDate.of(2021, 7, 1);
        LocalDate approveDt = LocalDate.of(2021, 7, 10);
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);

        EmployeeLeave t = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt,
                "bbb");
        assertTrue(t.isApproved());
    }

    @Test
    void isCanceled() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);
        LocalDate endDt = LocalDate.of(2021, 7, 17);
        LocalDate applyDt = LocalDate.of(2021, 7, 1);
        LocalDate approveDt = LocalDate.of(2021, 7, 10);
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);

        EmployeeLeave t = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt,
                "bbb");
        assertTrue(t.isCanceled());
    }

    void getComment() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);
        LocalDate endDt = LocalDate.of(2021, 7, 17);
        LocalDate applyDt = LocalDate.of(2021, 7, 1);
        LocalDate approveDt = LocalDate.of(2021, 7, 10);
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);

        EmployeeLeave t = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt,
                "bbb");
        assertEquals("bbb", t.getComment());
    }

    void getLeaveType() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);
        LocalDate endDt = LocalDate.of(2021, 7, 17);
        LocalDate applyDt = LocalDate.of(2021, 7, 1);
        LocalDate approveDt = LocalDate.of(2021, 7, 10);
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);

        EmployeeLeave t = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt,
                "bbb");
        assertEquals("aaa", t.getLeaveType());
    }

    @Test
    void getLeaveLength() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);
        LocalDate endDt = LocalDate.of(2021, 7, 17);
        LocalDate applyDt = LocalDate.of(2021, 7, 1);
        LocalDate approveDt = LocalDate.of(2021, 7, 10);
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);

        EmployeeLeave t = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt,
                "bbb");
        assertEquals(3, t.getLeaveLength());
    }

    @Test
    void cancelLeave() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);
        LocalDate endDt = LocalDate.of(2021, 7, 17);
        LocalDate applyDt = LocalDate.of(2021, 7, 1);
        LocalDate approveDt = LocalDate.of(2021, 7, 10);
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);
        LocalDate cancelDt2 = LocalDate.of(2021, 7, 14);

        EmployeeLeave t = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt,
                "bbb");
        t.cancelLeave();
        assertEquals(LocalDate.now(), t.getCancelDt());

        t.cancelLeave(cancelDt2);
        assertEquals(cancelDt2, t.getCancelDt());
    }

    @Test
    void approveLeave() {
        LocalDate startDt = LocalDate.of(2021, 7, 15);
        LocalDate endDt = LocalDate.of(2021, 7, 17);
        LocalDate applyDt = LocalDate.of(2021, 7, 1);
        LocalDate approveDt = LocalDate.of(2021, 7, 10);
        LocalDate cancelDt = LocalDate.of(2021, 7, 13);
        LocalDate approveDt2 = LocalDate.of(2021, 7, 11);

        EmployeeLeave t = new EmployeeLeave(1, 12345678910L, "aaa", startDt, endDt, applyDt, approveDt, cancelDt,
                "bbb");
        t.approveLeave();
        assertEquals(LocalDate.now(), t.getApproveDt());

        t.approveLeave(approveDt2);
        assertEquals(approveDt2, t.getApproveDt());
    }

}
