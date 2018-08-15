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
		String str="이름 : "+getName()+"\t주소 : "+getAddress()
					+"\t나이 : "+getAge() +"\t취미 : "+getHobby();
		// String str=super.customerInfo()+"\t취미 : "+hobby;
		return str;
	}
}
