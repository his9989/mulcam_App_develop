package edu.jaen.java.util;

import java.util.HashSet;
import java.util.Iterator;

import edu.jaen.java.basic.Customer;

public class SetTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<>();	// HashSet set : ���� �ڷ����̵� ���� �� �ִ�.
												// HashSet<data type> set : data type�� ������ ���� �� �ִ�.
		Customer c = new Customer();
		set.add("a");
		set.add("1");
		set.add("c");
		
		Iterator<String> iterator = set.iterator(); // Iterator iterator : �ڷ��� ��� x
													// Iterator<Data type> iterator : ���� data type ���ǿ� ���缭 ����
		while(iterator.hasNext()) {
			//Object next = iterator.next();		// object�� ��� ���� �ڷ����̵� ��� ����. 
			String next = iterator.next();			// ���⵵ ���� data type ���ǿ� ���缭 ���ش�.
			
		}
	}
}