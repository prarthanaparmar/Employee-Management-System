package com.empmanagement.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class EmployeeLeaveBuilder {

    private int leaveId;
    private long empId;
    private LocalDate startDt;
    private LocalDate endDt;
    private LocalDateTime applyDt;
    private String leaveType;
    private LocalDateTime approveDt;
    
    public EmployeeLeaveBuilder() {
        this.leaveId = -1;
    }
    
    public EmployeeLeaveBuilder(EmployeeLeave el){
        this.empId = el.getEmpId();
        this.startDt = el.getStartDt();
        this.endDt = el.getEndDt();
        this.applyDt = el.getApplyDt();
        this.leaveType = el.getLeaveType();
        this.approveDt = el.getApproveDt();
    }

    public EmployeeLeaveBuilder setLeaveType(String leaveType) {
        if (EmployeeLeave.LEAVE_TYPE_PTO.equals(leaveType) || EmployeeLeave.LEAVE_TYPE_CASUAL.equals(leaveType)
            || EmployeeLeave.LEAVE_TYPE_SICK.equals(leaveType)){
                this.leaveType = leaveType;
            return this;
        } else {
            throw new IllegalArgumentException("Invalid leave type.");
        }
    }
    
    public EmployeeLeaveBuilder setStartDt(LocalDate startDt) {
        if (startDt != null && endDt != null && startDt.isAfter(endDt)){
            throw new IllegalArgumentException("Invalid Start date. Start date should be earlier than end date");
        } else {
            this.startDt = startDt;
            return this;
        }
    }

    public EmployeeLeaveBuilder setEndDt(LocalDate endDt) {
        if (startDt != null && this.endDt != null && endDt.isBefore(startDt)) {
            throw new IllegalArgumentException("Invalid Start date. Start date should be earlier than end date");
        } else {
            this.endDt = endDt;
            return this;
        }
    }
    
    public EmployeeLeaveBuilder setStartDt(LocalDateTime applyDt) {
        if (applyDt != null && approveDt != null && applyDt.isAfter(approveDt)){
            throw new IllegalArgumentException("Invalid apply date. Apply date should be earlier than approve date");
        } else {
            this.applyDt = applyDt;
            return this;
        }
    }

    public EmployeeLeaveBuilder setEndDt(LocalDateTime approveDt) {
        if (applyDt != null && this.approveDt != null && approveDt.isBefore(applyDt)) {
            throw new IllegalArgumentException("Invalid Apply date. Apply date should be earlier than approve date");
        } else {
            this.approveDt = approveDt;
            return this;
        }
    }

    public EmployeeLeaveBuilder setEmpId(long empId){
        this.empId = empId;
        return this;
    }

    public EmployeeLeaveBuilder setLeaveId(int leaveId){
        this.leaveId = leaveId;
        return this;
    }

    // public EmployeeLeave build() {
    //     if (this.isValid()){
    //         return new EmployeeLeave(empId, leaveType, startDt, endDt, applyDt, leaveId, approveDt);
    //     } else {
    //         throw new IllegalStateException("Invalid EmployeeLeaveBuilder state.");
    //     }

    // }

    public boolean isValid() {
        if (this.empId < 0 || this.startDt == null || this.endDt == null || this.applyDt == null || this.leaveType == null){
            return false;
        } else {
            return true;
        }
    }

}
