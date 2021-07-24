package com.empmanagement.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static Date getTodaysDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);

        calendar.set(Calendar.HOUR_OF_DAY, 0);

        Date lastSalaryDay = calendar.getTime();
        return lastSalaryDay;
    }
}
