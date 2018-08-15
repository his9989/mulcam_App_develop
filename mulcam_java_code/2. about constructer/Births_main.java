package edu.jaen.java;

public class Births_main {

	public static void main(String[] args) {
		Births c = new Births();
		System.out.println(c.toString());
		
		Births b = new Births(1995, 1, 24);
		System.out.println(b.toString());

		Births d = new Births(2018, 8);
		System.out.println(d.toString());
		
	}

}
