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
		

		/*  Iterator ��� 
		Iterator<String> i=list.iterator();
		while( i.hasNext()){
			   String ob=i.next();
			   //ó��
			   System.out.println(ob);//ob.toString()
		}
		*/

		/*  for ~ each ���� ��� */
		for(String ob:  list){

			   //ó��
			   System.out.println(ob);//ob.toString()
		}

	}
}
