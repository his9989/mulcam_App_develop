package edu.jaen.java.inheritance;

public class VipMember extends Member {
	String hobby;

	public VipMember() {
		super();
		System.out.println("vipMember Constuctor");
	}

	public VipMember(String name, int age, String email, String hobby) {
		super(name, age, email);
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "VipMember [hobby=" + hobby + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}
}