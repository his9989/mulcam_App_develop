package com.my;

import java.util.Scanner;

public class input {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("���� �Է��Ͻÿ�");
		int input = s.nextInt();
		System.out.println("�Է��� ���� : " + input);
		
		System.out.println("String�� �Է��Ͻÿ�");
		String name = s.next();
		System.out.println("�Է��� �̸��� : " + name);
	}
}
