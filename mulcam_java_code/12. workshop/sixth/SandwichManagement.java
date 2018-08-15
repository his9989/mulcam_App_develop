package com.my.java.sixth;

public class SandwichManagement {
	Sandwich[] arr= new Sandwich[10];
	
	int index;
	
	public int addOrder(Sandwich s) {
		arr[index] = s;
		return index;
	}
	
	public void printOrderList() {
		for(int i = 0;i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public void serveOrder(int ordernum) {
		arr[ordernum] = arr[index-1];
		index--;
	}
}
