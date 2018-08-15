package edu.jaen.java.util;

import java.util.ArrayList;
import java.util.Iterator;

import edu.jaen.java.basic.Customer;

public class ListTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		ArrayList list = new ArrayList();
		//ArrayList<Data Type> list = new ArrayList();
				// data type을 설정해서 밑에서 add를 받는 조건을 설정할 수 있다.
		
		list.add(1);
		list.add("korea");
		list.add(3.4);
		list.add(c);
		///
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		System.out.println(list);

	}

}
