package com.empmanagement.dao;

import java.util.List;

import com.empmanagement.domain.Notification;

public interface NotificationDAO {

    /**
     * Create or update notification
     * 
     * @param notification notification
     * @return true if creation or updation is successful.
     */
    public boolean createOrUpdateNotification(Notification notification);

    /**
     * Get all notifications by employee id
     * 
     * @param empId employee id
     * @return list of notifications
     */
    public List<Notification> getNotifications(long empId);

    /**
     * Get notification by notification id
     * 
     * @param notificationId notification id
     * @return notification
     */
    public Notification getNotification(int notificationId);
}