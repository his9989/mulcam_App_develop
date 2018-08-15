package edu.jaen.java;

public class Student {
	private String number;
	private String name;
	private String major;
	private char gender;
	private int age;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Student() {
		super();
	}

	public Student(String number, String name, String major, char gender, int age) {
		super();
		this.number = number;
		this.name = name;
		this.major = major;
		this.gender = gender;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [number=" + number + ", name=" + name + ", major=" + major + ", gender=" + gender + ", age="
				+ age + "]";
	}

	public void printStudent() {
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + major);
		System.out.println("���� : " + gender);
		System.out.println("�й� : " + number);
		System.out.println("���� : " + age);
		System.out.println(" ");
	}
}
