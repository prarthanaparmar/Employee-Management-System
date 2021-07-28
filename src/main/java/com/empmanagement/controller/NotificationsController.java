package com.empmanagement.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.empmanagement.domain.Notification;
import com.empmanagement.service.INotificationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Notification controller
 * @author Neel Patel
 */
@Controller
public class NotificationsController {
	@Autowired
	private INotificationService notificationService;

	private Logger logger = LoggerFactory.getLogger(LeaveManagementController.class);

	/**
	 * Handles get requests
	 * @param session HttpSession
	 * @param model Model
	 * @return Template name
	 */
	@GetMapping("/ems/notifications")
	public String getNotifications(HttpSession session, Model model) {
		Long employeeId = (Long) session.getAttribute("EMP_ID");

		if (employeeId == null) {
			return "redirect:/ems/login";
		}

		Long empId = employeeId;
		List<Notification> notifications = notificationService.getNotifications(empId);
		model.addAttribute("notifications", notifications);
		logger.debug("Total notifications retrieved: " + notifications.size());
		return "notifications";
	}

}
