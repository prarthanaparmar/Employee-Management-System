package com.empmanagement.domain;

import java.time.LocalDate;

/**
 * @author Neel Patel
 */
public class Notification {

    private int notificationId;
    private long empId;
    private String message;
    private LocalDate createDate;

    public Notification(int notificationId, long empId, String message, LocalDate createDate) {
        this.notificationId = notificationId;
        this.empId = empId;
        this.message = message;
        this.createDate = createDate;
    }

    public Notification(long empId, String message) {
        this(-1, empId, message, LocalDate.now());
    }

    /**
     * @return employee Id
     */
    public long getEmpId() {
        return this.empId;
    }

    /**
     * @return notification id
     */
    public int getNotificationId() {
        return this.notificationId;
    }

    /**
     * @return notification message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * @return notification date
     */
    public LocalDate getCreateDate() {
        return this.createDate;
    }
}
