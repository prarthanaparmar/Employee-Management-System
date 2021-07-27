package com.empmanagement.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;


import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empmanagement.service.IEmpRegService;
import com.empmanagement.service.IOffBoardingService;
import com.empmanagement.service.IReimbursementService;
import com.empmanagement.service.ISendEmailService;
import com.empmanagement.service.SendEmailService;
import com.empmanagement.util.PasswordEncoder;
/**
 * This class takes care of Employee registration related operations
 *
 * @author Prarthanaben Parmar
 *
 */

@Controller
public class EmployeeRegController {

    @Autowired
    private IEmpRegService empreg;

    @Autowired
    private ISendEmailService sendEmail;

    private String companyEmail;
    private String registerStatus;
    private Long empId;
    private String password;
    private String encodePass;
    private String message;
    private String subject;
    private int deptId;
    static final String STATUS = "active";
    private String empUserName;

    @GetMapping("ems/hr-homescreen")
    public String hrhomescreen(HttpSession session, Model model) {
        Long employeeId = (Long) session.getAttribute("EMP_ID");

        if (employeeId == null) {
            return "redirect:/ems/login";
        }
        return "hr-homescreen";
    }

    @GetMapping("/ems/employee-registration")
    public String empRegistrationForm(HttpSession session, Model model) {
        Long employeeId = (Long) session.getAttribute("EMP_ID");

        if (employeeId == null) {
            return "redirect:/ems/login";
        }
        return "employee-registration";
    }

    @PostMapping("/ems/employee-registration/submit")
    public String regEmpDetails(@RequestParam(name = "firstname", required = true) String firstname, @RequestParam(name = "lastname", required = true) String lastname, @RequestParam(name = "email", required = true) String email,
                                @RequestParam(name = "doj", required = true) Date doj, @RequestParam(name = "dob", required = true) Date dob, @RequestParam(name = "role", required = true) String role,
                                @RequestParam(name = "grade", required = true) String grade, @RequestParam(name = "deptname", required = true) String deptname,
                                @RequestParam(name = "team", required = true) String team,
                                RedirectAttributes redirectAttribute,
                                Model model) throws NoSuchAlgorithmException {
        companyEmail = empreg.generateEmail(firstname, lastname);
        deptId = empreg.getDeptId(deptname);

        if (deptId == 0) {
            redirectAttribute.addFlashAttribute("error", "Please enter a valid department");
            return "redirect:/ems/employee-registration";
        } else {
            registerStatus = empreg.registerEmp(empreg.getFullName(firstname, lastname), companyEmail, doj, dob, role, grade, deptId, team, STATUS, email);
            empId = empreg.getEmpId(empreg.getFullName(firstname, lastname), dob);
            password = empreg.getPassword();
            encodePass = PasswordEncoder.encodePassword(password);

            if (empId == 0) {
                redirectAttribute.addFlashAttribute("error", "Please try again");
                return "redirect:/ems/employee-registration";
            }

            String loginDetails = empreg.updateLogin(empreg.getEmpUserName(firstname, lastname), encodePass, empId);
            empUserName = empreg.getUsername(empId);
            message = "Hello Welcome Aboard! Your employee Id is: " + empId + ", your username is " + empUserName + " ,password: " + password + " and company email: " + companyEmail;
            subject = "Welcome Onboard" + firstname;

            if (registerStatus.equals("success") && loginDetails.equals("success")) {
                sendEmail.sendMail(subject, message, email);
                redirectAttribute.addFlashAttribute("success", "The details of new employee have been saved successfully");
            } else {
                redirectAttribute.addFlashAttribute("error", "The details were not saved properly. Please try again");
                return "redirect:/ems/employee-registration";
            }
        }
        return "redirect:/ems/employee-registration";
    }
}