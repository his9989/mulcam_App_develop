package edu.jaen.java.util;

import edu.jaen.java.basic.Customer;
import edu.jaen.java.basic.MainCustomer;

public class ArrayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer c = new Customer();
		MainCustomer mc = new MainCustomer();
		
		ArrayGeneric a = new ArrayGeneric();
		a.add(11);
		a.add("aa");
		a.add(c);
		a.add(mc);
		
		System.out.println(a.toString());

	}

}
