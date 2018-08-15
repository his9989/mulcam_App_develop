package edu.jaen.java.util;

import java.util.HashSet;
import java.util.Iterator;

import edu.jaen.java.basic.Customer;

public class SetTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<>();	// HashSet set : 무슨 자료형이든 넣을 수 있다.
												// HashSet<data type> set : data type에 조건을 넣을 수 있다.
		Customer c = new Customer();
		set.add("a");
		set.add("1");
		set.add("c");
		
		Iterator<String> iterator = set.iterator(); // Iterator iterator : 자료형 상관 x
													// Iterator<Data type> iterator : 위의 data type 조건에 맞춰서 설정
		while(iterator.hasNext()) {
			//Object next = iterator.next();		// object인 경우 무슨 자료형이든 상관 없다. 
			String next = iterator.next();			// 여기도 위의 data type 조건에 맞춰서 해준다.
			
		}
	}
}