package edu.jaen.java.util;
import java.util.*;

class ListTest 
{
	public static void main(String[] args) 
	{
		Collection list=new ArrayList();
		Collection set=new ArrayList();
		list.add("seoul");
		list.add("korea");
		list.add("123");
		list.add("korea");
		///
		System.out.println(list);
		//사용
		Iterator i=list.iterator();
		while( i.hasNext()){
			   Object ob=i.next();
			   //처리
			   System.out.println(ob);//ob.toString()
		}
		
		for(Object s: set) {
			System.out.println(set.toString());
		}
		
		

	}
}
