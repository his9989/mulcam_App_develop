package edu.jaen.java.objectio;

public class Customer  implements java.io.Serializable
{
	String  name;
	String  address;
	transient int	    age;

	public String toString(){
		return "�̸� : "+name+"\t�ּ� : "+address+"\t���� : "+age;
	}
}


