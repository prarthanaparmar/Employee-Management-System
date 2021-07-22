package com.empmanagement.service;

import java.util.List;

import com.empmanagement.dao.NotificationDAO;
import com.empmanagement.domain.EmployeeLeave;
import com.empmanagement.domain.LeaveBalance;
import com.empmanagement.domain.Notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

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
