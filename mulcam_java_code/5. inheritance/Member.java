package edu.jaen.java.inheritance;

public class Member {
	String name;
	int age;
	String email;
	
	public Member() {
		System.out.println("Member Constructer");
	}
	
	public Member(String name, int age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
	}	
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", email=" + email + "]";
	}
}
