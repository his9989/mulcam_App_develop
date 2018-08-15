package edu.jaen.java.util;
import java.util.*;

class ListTest5 
{
	public static void main(String[] args) 
	{
		Collection<String> list=new ArrayList<String>();
		list.add("seoul");
		list.add("korea");
		list.add("123");
		list.add("korea");
		

		/*  Iterator 荤侩 
		Iterator<String> i=list.iterator();
		while( i.hasNext()){
			   String ob=i.next();
			   //贸府
			   System.out.println(ob);//ob.toString()
		}
		*/

		/*  for ~ each 备巩 荤侩 */
		for(String ob:  list){

			   //贸府
			   System.out.println(ob);//ob.toString()
		}

	}
}
