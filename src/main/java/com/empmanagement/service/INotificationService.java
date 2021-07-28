package com.empmanagement.service;

import java.util.List;

import com.empmanagement.domain.Notification;

import org.springframework.stereotype.Service;

public interface INotificationService {

	public List<Notification> getNotifications(long empId);

	public Notification getNotification(int notificationId);

	public boolean createOrUpdateNotification(Notification notification);

	public boolean createNotification(long empId, String message);

}
