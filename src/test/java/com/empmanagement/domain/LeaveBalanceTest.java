package com.empmanagement.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

/**
 * @author @neelp (Neel Patel)
 */
public class LeaveBalanceTest {

    /**
     * Test getter setter for PTO leaves
     */
    @Test
    public void testGetSetPtoLeaves(){
        LeaveBalance lb = new LeaveBalance(1);
        lb.setPtoLeaves(3);
        assertEquals(3, lb.getPtoLeaves(), "setPtoLeaves method is not updating pto leaves");
    }
   
    /**
     * Test getter setter for Casual leaves
     */
    @Test
    public void testGetSetCasualLeaves(){
        LeaveBalance lb = new LeaveBalance(1);
        lb.setCasualLeaves(30);
        assertEquals(30, lb.getCasualLeaves(), "setCasualLeaves method is not updating casual leaves");
    }
    
    /**
     * Test getter setter for sick leaves
     */
    @Test
    public void testGetSetSickLeaves(){
        LeaveBalance lb = new LeaveBalance(1);
        lb.setSickLeaves(7);
        assertEquals(7, lb.getSickLeaves(), "setSickLeaves method is not updating sick leaves");
    }
    
    /**
     * Test getter for empId
     */
    @Test
    public void testGetEmpId(){
        LeaveBalance lb = new LeaveBalance(7);
        assertEquals(7, lb.getEmpId(), "getEmpId method is not returning correct empId");
    }
}
