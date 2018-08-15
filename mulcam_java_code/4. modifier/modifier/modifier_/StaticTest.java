package edu.jaen.java.modifier;

import java.lang.Math;

class StaticTest {
	static int count;
	int a;

	static void setCount(int k) {
		count = k;
		System.out.println("setCount() : " + count);
	}

	static {
		System.out.println("static initialize! count: " + count);
	}

	{
		System.out.println("instance initialize...");
		System.out.println("√ ±‚»≠");
	}

	public StaticTest() {

		System.out.println("Static Constructor");
		
	}
	

	public StaticTest(int a) {
		super();
		
		System.out.println("Static Constructor");
	}


	public static void main(String args[]) {
		System.out.println("Main Start!");
		StaticTest t1=new StaticTest(3);
//		StaticTest.setCount(10);

//		System.out.println(Math.sin(60));

//		System.out.println();
//		StaticTest.setNum(10);
//		StaticTest si = new StaticTest();
//		System.out.println("Main...");
//		StaticTest si2 = new StaticTest();
	}
}
