package com.my.java.first;

public class Accumulator {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < 101; i++) {
			sum += i;
		}
		System.out.println(sum);
	}

}
