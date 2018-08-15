package edu.jaen.java.util;
import java.util.*;
public class ArrayListTest {	
	ArrayList v;  
	public ArrayListTest(){
		v=new ArrayList();
	}
	public void addData(int i){
		//v.addElement(new Integer(i));
		v.add(new Integer(i));
	}
	public void addData(float f){
		v.add(new Float(f));
	}
	public void addData(String s){
		v.add(s);
	}
	public void addData(char a[]){
		v.add(a);
	}
	public void delete(int k){
		v.remove(k);
		printList();
	}
	public void search(Object ob){
		if(v.contains(ob)){
			int i = v.indexOf(ob);
			System.out.println("�ش� ��ü�� "+(i+1)
									+"��°�� �ֽ��ϴ�.");
		}else
			System.out.println("�ش� ��ü�� �����ϴ�.");
	}

	public void printList(){
		Object o;
		int len = v.size();   //���� �����Ͱ� ����ִ� ũ�⸦ ���Ѵ�.
		System.out.println("Number of vector elements is "+len+" and they are:");
		for (int i = 0; i < len; i++){
			o=v.get(i);
			if (o instanceof char[]){//char���迭 �ΰ�?
				System.out.println(String.copyValueOf(
					       (char[]) o));//�迭���ڸ� String���� �ٲ��ִ� �޼ҵ�
			} else {
				System.out.println(o.toString());
			}
		}
	}
	public static void main(String[] args){
		ArrayListTest mv = new ArrayListTest();
		int digit = 5;
		float real = 3.14F;
		char letters[] = {'a', 'b', 'c', 'd'};
		String s = new String("Hi there!");
		mv.addData(digit);
		mv.addData(real);
		mv.addData(s);
		mv.addData(letters);
		mv.printList();
		mv.search(s);
		mv.delete(2);
	}
}
