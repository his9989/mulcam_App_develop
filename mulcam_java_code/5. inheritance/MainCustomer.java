package edu.jaen.java.inheritance;
class  MainCustomer  extends Customer{
	private String  hobby;

	public MainCustomer(){}
	public MainCustomer(String name, String address, int age, String hobby){
		setName(name);
		setAddress(address);
		setAge(age);
		setHobby(hobby);
	}

	public void setHobby(String hobby){
		this.hobby=hobby;
	}
	public String getHobby(){
		return hobby;
	}

	public  String toString(){
		String str="�̸� : "+getName()+"\t�ּ� : "+getAddress()
					+"\t���� : "+getAge() +"\t��� : "+getHobby();
		// String str=super.customerInfo()+"\t��� : "+hobby;
		return str;
	}
}
