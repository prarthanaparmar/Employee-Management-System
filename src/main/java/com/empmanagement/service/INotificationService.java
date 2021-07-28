package com.empmanagement.service;

import java.util.List;

import com.empmanagement.domain.Notification;

/**
 * Notification service interface
 * 
 * @author Neel Patel
 */
public interface INotificationService {

	/**
	 * 
	 * @param empId employee id
	 * @return list of notifications
	 */
	public List<Notification> getNotifications(long empId);

	/**
	 * 
	 * @param notificationId notification id
	 * @return notification
	 */
	public Notification getNotification(int notificationId);

	/**
	 * 
	 * @param notification notification
	 * @return true if notification is created or updated
	 */
	public boolean createOrUpdateNotification(Notification notification);

	/**
	 * 
	 * @param empId   employee id
	 * @param message message
	 * @return true if notification is created or updated
	 */

	public boolean createNotification(long empId, String message);

}
