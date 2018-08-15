package edu.jaen.java.inheritance;

public class VVIP extends VipMember {
	int money;
	
	public VVIP() {
		super();
		System.out.println("VVIP Constructor");
	}
	
	public VVIP(int money) {
		this.money = money;
	}
	
	public VVIP(String name, int age 
			, String email, String hobby, int money) {
		super(name, age, email, hobby);
		this.money = money;
	}

	@Override
	public String toString() {
		return "VVIP [money=" + money + ", hobby=" + hobby + ", name=" + name + ", age=" + age + ", email=" + email
				+ "]";
	}
	
	
}
