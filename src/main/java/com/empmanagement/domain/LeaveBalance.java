package com.empmanagement.domain;

/**
 * Data model which represents employee leaves
 * @author @neelp (Neel Patel)
 */
public class LeaveBalance {
    private long empId;
    private int ptoLeaves;
    private int casualLeaves;
    private int sickLeaves;

    public LeaveBalance(long empId) {
        this.empId = empId;
    }

    /**
     * Updates PTO leaves balance and return old PTO leaves balance
     * @param ptoLeaves PTO leave balance
     * @return old PTO leave balance
     * @throws IllegalArgumentException if `ptoLeaves` is less than zero
     */
    public int setPtoLeaves(int ptoLeaves) {
        if (ptoLeaves >= 0){
            int t = this.ptoLeaves;
            this.ptoLeaves = ptoLeaves;
            return t;
        }else{
            throw new IllegalArgumentException("PTO Leave Balance can't be negative.");
        }
    }
    
    /**
     * Updates Casual leaves balance and return old Casual leaves balance
     * @param casualLeaves Casual leave balance
     * @return old Casual leave balance
     * @throws IllegalArgumentException if `casualLeaves` is less than zero
     */
    public int setCasualLeaves(int casualLeaves) {
        if (casualLeaves >= 0){
            int t = this.casualLeaves;
            this.casualLeaves = casualLeaves;
            return t;
        }else{
            throw new IllegalArgumentException("Casual Leave Balance can't be negative.");
        }
    }

    /**
     * Updates Sick leaves balance and return old Sick leaves balance
     * @param sickLeaves Sick leave balance
     * @return old Sick leave balance
     * @throws IllegalArgumentException if `sickLeaves` is less than zero
     */
    public int setSickLeaves(int sickLeaves) {
        if (sickLeaves >= 0){
            int t = this.sickLeaves;
            this.sickLeaves = sickLeaves;
            return t;
        }else{
            throw new IllegalArgumentException("Sick Leave Balance can't be negative.");
        }
    }

    /**
     * @return PTO Leaves
     */
    public int getPtoLeaves(){
        return this.ptoLeaves;
    }

    /**
     * @return Casual Leaves
     */
    public int getCasualLeaves(){
        return this.casualLeaves;
    }
    
    /**
     * @return Sick Leaves
     */
    public int getSickLeaves(){
        return this.sickLeaves;
    }

    /**
     * @return Employee ID
     */
    public long getEmpId(){
        return this.empId;
    }
}
