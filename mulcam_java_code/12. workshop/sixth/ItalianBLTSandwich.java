package com.my.java.sixth;

public class ItalianBLTSandwich extends Sandwich {
	public void prepareIngredient() {
		setIngredient("��3, ������1, ���1, ��3, �丶��1");
		setAmount(3);	} 
	
	public void printInfo() {
		System.out.println("Ingredient : " + getIngredient());
		System.out.println("Amount : " + getAmount());	}
}
