package edu.jaen.java.inheritance;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person();
		p.age = 21;
		p.name = "¶Õ—Í¨G";
		
		Student s = new Student();
		s.age = 25;
		s.name = "ÇÑÀÎ¼ö";
		s.number = "B411236";
		
		System.out.println(p);
		System.out.println(s);
	}
}
