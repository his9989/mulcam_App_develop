package edu.jaen.java.modifier;

public class StaticInnerClass {
	
	int a;
	
	void PrintStatic() {
		System.out.println("a->"+a);
		Inner in = new Inner();
		in.innerA=100;
		in.printInner();
	}
	
	public static class Inner{							// static�� main���� Inner�� ����ϱ� ���ؼ��� static class Inner��� �ؾ��Ѵ�.
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
