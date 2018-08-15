package edu.jaen.java.util;
import java.util.*;

import edu.jaen.java.basic.Customer;

class SetTest 
{
	public static void main(String[] args) 
	{
		Collection set=new HashSet();
		set.add("seoul");
		set.add("korea");
		set.add("123");
		set.add("korea");
		
		System.out.println(set);
		
		if(set.contains("seoul")) {
			System.out.println("good");
		}
		else {
			System.out.println("bad");
		}
		///
		System.out.println(" ");
		ArrayList list = new ArrayList<>();
		
		list.add("seoul");
		list.add("korea");
		list.add("123");
		list.add("korea");
		list.add("hello");
		Customer c = new Customer();
		set.add(c);
		
		System.out.println(list.toString());
		System.out.println(" ");

		list.set(2, "multi");
		System.out.println(list.toString());
		System.out.println(" ");

		list.remove("multi");
		System.out.println(list.toString());
		System.out.println(" ");

		list.remove("korea");
		System.out.println(list.toString()); 	// first korea will remove
		System.out.println(" ");

		//사용
		Iterator i=set.iterator();
		while( i.hasNext()){
			   Object ob=i.next();
			   //처리
			   System.out.println(ob);//ob.toString()
		}
		list.get(0);

	}
}
