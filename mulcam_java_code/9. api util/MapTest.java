package edu.jaen.java.util;
import java.util.*;

import edu.jaen.java.basic.Customer;

class MapTest
{
	public static void main(String[] args) 
	{
		Map<Integer, String> map=new HashMap();
//		map.put("city","seoul");
//		map.put("na","korea");
//		map.put("ho","123");
//		map.put("na2","korea");

		map.put(1,"seoul");
		map.put(2,"korea");
		map.put(3,"123");
		map.put(4,"korea");
		
		Customer c1 = new Customer(4, "Han");
		Customer c2 = new Customer(3, "Kim");
		Customer c3 = new Customer(2, "Park");
		Customer c4 = new Customer(1, "Lee");

		Map<Customer, Customer> map2 = new HashMap();
		map2.put(c1, c1);
		map2.put(c2, c2);
		map2.put(c3, c3);
		map2.put(c4, c4);

//		System.out.println("city:"+map.get("city"));
//		System.out.println("nation:"+map.get("na")+"\n");
		
		Iterator i=map.keySet().iterator();
		while( i.hasNext()){
			   Object key=i.next();
			   Object value=map.get(key);
			   //Ã³¸®
			   System.out.println(key+":"+value);
		}

	}
}
