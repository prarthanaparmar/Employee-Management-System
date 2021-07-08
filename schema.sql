-- Emplyee Leave History Table 
Create Table employee_leaves(
	leaveId int(11) primary key auto_increment,
    empId int(11) not null references employee(empId),
    startDt date not null,
    endDt date not null,
    leaveType varchar(50) not null,
    reason ENUM('PTO', 'CASUAL', 'SICK') not null,
    applyDt datetime not null,
    approveDt datetime,
    cancelDt datetime
);

-- Employee Leave Balance Table
Create Table employee_leave_balance(
	empId int(11) primary key references employee(empId),
    pto_leaves int(11) not null,
    casual_leaves int(11) not null,
    sick_leaves int(11) not null
);
