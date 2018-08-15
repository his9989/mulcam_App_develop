package com.my.java.sixth;

public class SandwichTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int ordernum1 = 0;
		int ordernum2 = 0;
		
		SandwichManagement man = new SandwichManagement();
		TurkeyBaconAvocadoSandwich t = new TurkeyBaconAvocadoSandwich();
		ordernum1 = man.addOrder(t);
		
		ItalianBLTSandwich i = new ItalianBLTSandwich();
		ordernum2 = man.addOrder(t);
		
		man.printOrderList();
		man.serveOrder(ordernum1);
		man.serveOrder(ordernum2);
		
	}
}