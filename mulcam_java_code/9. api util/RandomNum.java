package edu.jaen.java.util;
import java.util.*;

public class RandomNum {
	public static void main(String args[]) 	{		
		Random r = new Random();
		int i=0;
		while(i<10){
			i = r.nextInt(100);
			System.out.println("0 ~ 100 ������ ���� ���ڴ� " + i);
		}
		i = r.nextInt(1000);
		System.out.println("0 ~ 1000 ������ ���� ���ڴ� " + i);		
	}
}