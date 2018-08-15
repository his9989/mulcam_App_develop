package edu.jaen.java.util;
import java.util.*;
class HashTest{
	public static void main(String[] args){
		Hashtable h = new Hashtable();
		h.put("이름", "홍길동");
		h.put("주소", "마포구");
		h.put("나이", new Integer(21));
		h.put("나이",new Integer(31));
		System.out.println((h.get("주소")));
		System.out.println((Integer)(h.get("나이")));
		System.out.println((Integer)(h.get("나이")));
		System.out.println(h.size()+"============");
		for (Enumeration m = h.elements(); 
						m.hasMoreElements(); ){ //elements()의 리턴타입은 Enumeration(Interface임)
			System.out.println(m.nextElement());
		}
	}
}
//Enumeration내용
/*package java.util;
public interface Enumeration {
    boolean hasMoreElements();
    Object nextElement();
}*/