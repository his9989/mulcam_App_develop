package com.my.java.sixth;

public class ItalianBLTSandwich extends Sandwich {
	public void prepareIngredient() {
		setIngredient("빵3, 베이컨1, 계란1, 햄3, 토마토1");
		setAmount(3);	} 
	
	public void printInfo() {
		System.out.println("Ingredient : " + getIngredient());
		System.out.println("Amount : " + getAmount());	}
}
