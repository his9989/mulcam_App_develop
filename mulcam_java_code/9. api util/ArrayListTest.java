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
			System.out.println("해당 객체가 "+(i+1)
									+"번째에 있습니다.");
		}else
			System.out.println("해당 객체가 없습니다.");
	}

	public void printList(){
		Object o;
		int len = v.size();   //실제 데이터가 들어있는 크기를 구한다.
		System.out.println("Number of vector elements is "+len+" and they are:");
		for (int i = 0; i < len; i++){
			o=v.get(i);
			if (o instanceof char[]){//char형배열 인가?
				System.out.println(String.copyValueOf(
					       (char[]) o));//배열인자를 String으로 바꿔주는 메소드
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
