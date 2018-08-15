package edu.jaen.java.overloading;
class OverloadTest 
{
	public int add(int i, int j){
		// statements...
		return i+j;
	}
	public float add(float i, float j){
		// statements...
		return i+j;
	}
	public float add(int i, float j){
		// statements...
		return i+j;
	}
	public float add(float i, int j){
		return add(j,i);
	}
	public static void main(String[] args) 
	{
		OverloadTest ot=new OverloadTest();
		int result=ot.add(30,40);
		float result2=ot.add(3.4f,5.2f);
		float result3=ot.add(3.4f, 40);
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
	}
}
