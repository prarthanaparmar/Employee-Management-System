package com.empmanagement.util;

import java.util.Random;


public class RandomUtils {
	
	static final int MAX = 9000;
	static final int MIN = 1000;
	
	
	public int random() {
		Random random = new Random();
		int num =  random.nextInt(MAX) + MIN;
		return num;
	}

}
