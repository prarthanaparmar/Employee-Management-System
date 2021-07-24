package com.empmanagement.util;

import java.text.DecimalFormat;

public class DecimalFormatter {
	
	public static Double format(Double amount) {
		Double formattedDate;
		String format = "#.##";
		 DecimalFormat df = new DecimalFormat(format);
		 formattedDate = Double.parseDouble(df.format(amount));
		return formattedDate;
		 
	}

}
