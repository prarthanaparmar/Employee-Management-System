package com.empmanagement.domain;

public class Salary {
Earnings earnings;
Deductions deductions;
double netPay;

public Earnings getEarnings() {
	return earnings;
}
public void setEarnings(Earnings earnings) {
	this.earnings = earnings;
}
public Deductions getDeductions() {
	return deductions;
}
public void setDeductions(Deductions deductions) {
	this.deductions = deductions;
}
public double getNetPay() {
	return netPay;
}
public void setNetPay(double netPay) {
	this.netPay = netPay;
}

}
