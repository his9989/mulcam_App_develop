package edu.jaen.java.inheritance;
class InheritTest 
{
	public static void main(String[] args) 
	{
		Customer c=new Customer("홍길동","서울",20);
		System.out.println(c.toString());
		MainCustomer mc=new MainCustomer("소나무","부산",21,"여행");
		System.out.println(mc);
	}
}
