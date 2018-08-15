package com.my.java.first;

public class TenFactorial {

	public static void main(String[] args) {
		int mul=1;
		for(int i=1; i<11; i++) {
			mul*=i;
		}
		System.out.println(mul);
	}

}
