package com.my.java.sixth;

public abstract class Sandwich {
	protected String ingredient;
	protected int amount;
	
	
	
	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public abstract void prepareIngredient();
	
	public abstract void printInfo();
}
