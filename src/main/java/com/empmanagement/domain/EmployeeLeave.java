package com.empmanagement.domain;

import java.time.LocalDate;

/**
 * Data model which represents employee leave
 * 
 * @author @neelp (Neel Patel)
 */
public class EmployeeLeave {
    public static final String LEAVE_TYPE_PTO = "PTO";
    public static final String LEAVE_TYPE_CASUAL = "CASUAL";
    public static final String LEAVE_TYPE_SICK = "SICK";

    private int leaveId;
    private long empId;
    private LocalDate startDt;
    private LocalDate endDt;
    private LocalDate applyDt;
    private String leaveType;
    private String comment;
    private LocalDate approveDt;
    private LocalDate cancelDt;

    public EmployeeLeave(int leaveId, long empId, String leaveType, LocalDate startDt, LocalDate endDt,
            LocalDate applyDt, LocalDate approveDt, LocalDate cancelDt, String comment) {
        this.empId = empId;
        this.leaveType = leaveType;
        this.startDt = startDt;
        this.endDt = endDt;
        this.applyDt = applyDt;
        this.leaveId = leaveId;
        this.comment = comment;
        this.approveDt = approveDt;
        this.cancelDt = cancelDt;
    }

    /**
     * @return Employee ID
     */
    public long getEmpId() {
        return this.empId;
    }

    /**
     * @return Leave ID
     */
    public int getLeaveId() {
        return this.leaveId;
    }

    /**
     * @return Start Date
     */
    public LocalDate getStartDt() {
        return this.startDt;
    }

    /**
     * @return End Date
     */
    public LocalDate getEndDt() {
        return this.endDt;
    }

    /**
     * @return Apply Date
     */
    public LocalDate getApplyDt() {
        return this.applyDt;
    }

    /**
     * @return Apply Date
     */
    public LocalDate getApproveDt() {
        return this.applyDt;
    }
    
    /**
     * @return Cancel Date
     */
    public LocalDate getCancelDt() {
        return this.cancelDt;
    }

    /**
     * @return if leave is approved or not
     */
    public boolean isApproved() {
        return this.approveDt != null;
    }

    /**
     * @return leave message
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * @return Leave Type
     */
    public String getLeaveType() {
        return this.leaveType;
    }
}
