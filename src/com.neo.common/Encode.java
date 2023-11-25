package com.neo.common;

import java.security.SecureRandom;

public class Encode {
	private static final int RANDOM_BYTES = 4;
	private static final int DIGITS_PER_BYTE = 2;

    public static String generateRandomNumber() {
    	SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[RANDOM_BYTES];
        secureRandom.nextBytes(randomBytes);

        StringBuilder result = new StringBuilder();
        for (byte b : randomBytes) {
            int value = b & 0xFF; 
            String decimalValue = String.format("%0" + DIGITS_PER_BYTE + "d", value);
            result.append(decimalValue);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String generatedNumber = generateRandomNumber();
        System.out.println("Generated Number: " + generatedNumber);
    }
}
