package edu.jaen.java.modifier;

public class StaticInnerClass {
	
	int a;
	
	void PrintStatic() {
		System.out.println("a->"+a);
		Inner in = new Inner();
		in.innerA=100;
		in.printInner();
	}
	
	public static class Inner{							// static인 main에서 Inner을 사용하기 위해서는 static class Inner라고 해야한다.
		int innerA;
		void printInner() {
			System.out.println("InnerA -> "+innerA);
		}
	}
	
	public static void main(String[] args) {
		StaticInnerClass s = new StaticInnerClass();
		s.a=10;
		s.PrintStatic();
		StaticInnerClass.Inner in = new StaticInnerClass.Inner();
		in.printInner();
	}
}
