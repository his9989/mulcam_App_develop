package edu.jaen.java.modifier;

public class StaticInnerClass {
	int a;
	void printStatic() {
		System.out.println("a=>"+a);
		Inner in = new Inner();
		in.innerA= 100;
		in.printInner();
	}
	 public static class Inner{
		int innerA=50;
		void printInner(){
			System.out.println("InnerA=>"+innerA);
		}
	}

	public static void main(String[]args) {
		StaticInnerClass s =new StaticInnerClass();
		s.a=10;
		s.printStatic();
		StaticInnerClass.Inner in = new StaticInnerClass.Inner();
		in.printInner();
		
		
	}
}
