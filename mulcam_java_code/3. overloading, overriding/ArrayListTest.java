package edu.jaen.java.overloading;
import java.util.*;
public class ArrayListTest {	
	ArrayList v;  
	public ArrayListTest(){
		v=new ArrayList();
	}
	public void addData(int i){
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
	public static void main(String[] args){
		ArrayListTest mv = new ArrayListTest();
		int digit = 50;
		float real = 3.14F;
		String s = new String("데이타");
		char letters[] = {'a', 'b', 'c', 'd'};
		// 데이터 저장
		mv.addData(digit);
		mv.addData(real);
		mv.addData(s);
		mv.addData(letters);
		for(int i=0; i< mv.v.size(); i++){
			System.out.println(mv.v.get(i));
		}
	}
}
