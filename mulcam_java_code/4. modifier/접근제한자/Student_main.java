package edu.jaen.java;

import java.util.Random;

public class Student_main {

	public static void main(String[] args) {

		Student s = new Student();
		
		Random r = new Random();

		s.setNumber("B411236");
		s.setAge(24);
		s.setGender('��');
		s.setMajor("��ǻ�Ͱ���");
		s.setName("���μ�");
		
//		s.number = "B411236";			// value object class
//		s.major = "��ǻ�Ͱ���";
//		s.gender = '��';
//		s.name = "���μ�";
//		s.age = 24;
		
		System.out.println(s.toString());				// ���� class
		System.out.println(s);				// ���� class
		s.printStudent();								// ���� class
		
		Student s2 = new Student();
		
		s2.setNumber("2014020154");
		s2.setAge(23);
		s2.setGender('��');
		s2.setMajor("������а�");
		s2.setName("�ڼ���");
		
//		s2.number = "14000114";
//		s2.major = "������а�";
//		s2.gender = '��';
//		s2.name = "�ڼ���";
//		s2.age = 23;

		System.out.println(s2.toString());				// ���� class
		System.out.println(s2);				// ���� class
		s2.printStudent();
	}
}
