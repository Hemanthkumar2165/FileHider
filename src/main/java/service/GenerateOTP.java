package service;

import java.util.Random;

public class GenerateOTP {
	public static String getOTP() {
		Random rand = new Random();
		return String.valueOf(rand.nextInt(10000));
	}
}
