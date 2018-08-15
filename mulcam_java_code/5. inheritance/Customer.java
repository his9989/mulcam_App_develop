package edu.jaen.java.inheritance;
public class  Customer {
	private String  name;
	private String  address;
	private int	   age;
	
	public Customer(){}
	public Customer(String name, String address, int age){
		setName(name);
		setAddress(address);
		setAge(age);	
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
	public void setAge(int age){
		this.age=age;
	}
	public  int getAge(){
		return age;
	}
	public  String toString(){
		String str="이름 : "+name+"\t주소 : "+address+"\t나이 : "+age;
		return str;
	}
}
