package com.empmanagement.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomServiceImpl implements IRandomService {

		public int random() {
		Random random = new Random();
		int num =  random.nextInt(9000) + 1000;
		return num;
	}
}
