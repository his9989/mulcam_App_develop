package edu.jaen.java.usingio;
import java.util.*;

class  KeyboardTest{

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.print("이름 :");
		String name=s.next();
		System.out.print("나이 :");
		int age=s.nextInt();

		System.out.println("read data :"+name);
		System.out.println("read data :"+age);
		
	}
}