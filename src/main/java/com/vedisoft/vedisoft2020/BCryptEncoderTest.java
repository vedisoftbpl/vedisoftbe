package com.vedisoft.vedisoft2020;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		for(int i = 0; i<=10; i++) {
			String encodedString = encoder.encode("7389330515") ;
			System.out.println(encodedString) ;
		}
	}

}
