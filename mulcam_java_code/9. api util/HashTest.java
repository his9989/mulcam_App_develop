package edu.jaen.java.util;
import java.util.*;
class HashTest{
	public static void main(String[] args){
		Hashtable h = new Hashtable();
		h.put("�̸�", "ȫ�浿");
		h.put("�ּ�", "������");
		h.put("����", new Integer(21));
		h.put("����",new Integer(31));
		System.out.println((h.get("�ּ�")));
		System.out.println((Integer)(h.get("����")));
		System.out.println((Integer)(h.get("����")));
		System.out.println(h.size()+"============");
		for (Enumeration m = h.elements(); 
						m.hasMoreElements(); ){ //elements()�� ����Ÿ���� Enumeration(Interface��)
			System.out.println(m.nextElement());
		}
	}
}
//Enumeration����
/*package java.util;
public interface Enumeration {
    boolean hasMoreElements();
    Object nextElement();
}*/