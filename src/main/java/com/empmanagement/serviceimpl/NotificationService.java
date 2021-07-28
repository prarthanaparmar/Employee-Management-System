package com.empmanagement.serviceimpl;

import java.util.List;

import com.empmanagement.dao.NotificationDAO;
import com.empmanagement.domain.Notification;
import com.empmanagement.service.INotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Neel Patel
 */
@Service
public class NotificationService implements INotificationService {

	@Autowired
	NotificationDAO notificationDAO;

	public List<Notification> getNotifications(long empId) {
		// Retrieve notifications from notifications dao for given employee id
		return notificationDAO.getNotifications(empId);
	}

	public Notification getNotification(int notificationId) {
		// Retrive notification from notifications dao using notification id
		return notificationDAO.getNotification(notificationId);
	}

	public boolean createOrUpdateNotification(Notification notification) {
		return notificationDAO.createOrUpdateNotification(notification);
	}

	public boolean createNotification(long empId, String message) {
		return createOrUpdateNotification(new Notification(empId, message));
	}

}
