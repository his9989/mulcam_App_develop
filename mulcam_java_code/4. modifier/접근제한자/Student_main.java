package edu.jaen.java;

import java.util.Random;

public class Student_main {

	public static void main(String[] args) {

		Student s = new Student();
		
		Random r = new Random();

		s.setNumber("B411236");
		s.setAge(24);
		s.setGender('남');
		s.setMajor("컴퓨터공학");
		s.setName("한인수");
		
//		s.number = "B411236";			// value object class
//		s.major = "컴퓨터공학";
//		s.gender = '남';
//		s.name = "한인수";
//		s.age = 24;
		
		System.out.println(s.toString());				// 실행 class
		System.out.println(s);				// 실행 class
		s.printStudent();								// 실행 class
		
		Student s2 = new Student();
		
		s2.setNumber("2014020154");
		s2.setAge(23);
		s2.setGender('여');
		s2.setMajor("영어영문학과");
		s2.setName("박수진");
		
//		s2.number = "14000114";
//		s2.major = "영어영문학과";
//		s2.gender = '여';
//		s2.name = "박수진";
//		s2.age = 23;

		System.out.println(s2.toString());				// 실행 class
		System.out.println(s2);				// 실행 class
		s2.printStudent();
	}
}
