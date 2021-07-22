package com.empmanagement.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.empmanagement.domain.EmployeeLeave;
import com.empmanagement.domain.EmployeeLeaveBuilder;
import com.empmanagement.domain.LeaveBalance;
import com.empmanagement.domain.Notification;
import com.empmanagement.service.LeaveManagementService;
import com.empmanagement.service.NotificationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotificationsController {
	@Autowired
	private NotificationService notificationService;

	private Logger logger = LoggerFactory.getLogger(LeaveManagementController.class);

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
