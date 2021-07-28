package com.empmanagement.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.empmanagement.domain.EmployeeLeave;
import com.empmanagement.domain.EmployeeLeaveBuilder;
import com.empmanagement.domain.LeaveBalance;
import com.empmanagement.service.ILeaveManagementService;
import com.empmanagement.service.INotificationService;

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
public class LeaveManagementController {
	@Autowired
	private ILeaveManagementService leaveManagementService;

	@Autowired
	private INotificationService notificationService;

	private Logger logger = LoggerFactory.getLogger(LeaveManagementController.class);

	@GetMapping("/ems/leave-management")
	public String getLeaveManagement(HttpSession session, Model model) {
		Long employeeId = (Long) session.getAttribute("EMP_ID");

		if (employeeId == null) {
			return "redirect:/ems/login";
		}

		Long empId = employeeId;
		model.addAttribute("emp_id", empId);
		LeaveBalance lb = leaveManagementService.getLeaveBalance(empId);
		model.addAttribute("lb", lb);
		List<EmployeeLeave> els = leaveManagementService.getEmployeeLeaves(empId);
		model.addAttribute("els", els);
		return "leave-management";
	}

	@PostMapping(value = "/ems/leave-management/apply", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String applyLeave(HttpSession session, Model model, @RequestBody MultiValueMap<String, String> formData) {
		try {
			Long employeeId = (Long) session.getAttribute("EMP_ID");

			if (employeeId == null) {
				return "redirect:/ems/login";
			}

			EmployeeLeaveBuilder elb = new EmployeeLeaveBuilder();
			elb.setEmpId(employeeId);
			elb.setStartDt(LocalDate.parse(formData.get("startDt").get(0)));
			elb.setEndDt(LocalDate.parse(formData.get("endDt").get(0)));
			elb.setLeaveType(formData.get("leaveType").get(0));
			elb.setComment(formData.get("reason").get(0));
			elb.setApplyDt(LocalDate.now());

			if (leaveManagementService.applyLeave(elb.build())) {
				logger.info("Leave applied successfully");
				notificationService.createNotification(employeeId, "Leave Applied Successfully");
			} else {
				logger.error("Error while leave creation");
			}
		} catch (Exception ex) {
			logger.error("Error occurred while creating a leave, ex: " + ex);
		}
		return "redirect:/ems/leave-management";
	}

	@GetMapping(value = "/ems/leave-management/cancel")
	public String cancelLeave(HttpSession session, Model model, @RequestParam("leaveId") int leaveId) {
		try {
			Long employeeId = (Long) session.getAttribute("EMP_ID");

			if (employeeId == null) {
				return "redirect:/ems/login";
			}

			if (leaveManagementService.cancelLeave(leaveId)) {
				logger.info("Leave canceled successfully");
				notificationService.createNotification(employeeId, "Leave canceled successfully");
			} else {
				logger.error("Error while leave cancellation");
			}
		} catch (Exception ex) {
			logger.error("Error occurred while canceling a leave, ex: " + ex);
		}
		return "redirect:/ems/leave-management";
	}

}
