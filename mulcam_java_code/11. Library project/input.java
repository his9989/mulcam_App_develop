package com.my;

import java.util.Scanner;

public class input {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("값을 입력하시오");
		int input = s.nextInt();
		System.out.println("입력한 값은 : " + input);
		
		System.out.println("String을 입력하시오");
		String name = s.next();
		System.out.println("입력한 이름은 : " + name);
	}
}
