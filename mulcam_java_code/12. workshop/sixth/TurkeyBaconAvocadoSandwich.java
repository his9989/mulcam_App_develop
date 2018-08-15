package com.my.java.sixth;

public class TurkeyBaconAvocadoSandwich extends Sandwich {
	public void prepareIngredient() {
		setIngredient("»§2, º£ÀÌÄÁ1, ¾Æº¸Ä«µµ1, ÇÜ3");
		setAmount(3);
	}
	
	public void printInfo() {
		System.out.println("Ingredient : " + getIngredient());
		System.out.println("Amount : " + getAmount());
	}
}
