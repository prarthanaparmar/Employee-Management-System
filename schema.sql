-- Emplyee Leave History Table 
Create Table employee_leaves(
	leaveId int(11) primary key auto_increment,
    empId int(11) not null references employee(empId),
    startDt date not null,
    endDt date not null,
    leaveType varchar(50) not null,
    reason ENUM('PTO', 'CASUAL', 'SICK') not null,
    applyDt date not null,
    approveDt date,
    cancelDt date
);

-- Employee Leave Balance Table
Create Table employee_leave_balance(
	empId int(11) primary key references employee(empId),
    pto_leaves int(11) not null default 0,
    casual_leaves int(11) not null default 0,
    sick_leaves int(11) not null default 0
);

-- Employee Notifications
Create Table employee_notifications(
	notificationId int(11) primary key auto_increment,
    empId int(11) unique not null references employee(empId),
    message varchar(5000) not null,
    createDate date not null 
);
