package edu.jaen.java.overriding;
class Parent{
	int k=10;
	void over()	{
		System.out.println("Parent Class!");
	}
	void mParent(){
		System.out.println("Parent method");
	}
}
class Child   extends Parent{
	int k=20;
	void over() {   //Overriding
	
		System.out.println("Child class!");
	}
	void mChild(){
	
		System.out.println("Child method");
	}
}
class OverridingTest
{
	public static void main(String a[])
	{	
		Parent p=new Parent();
		System.out.println(p.k);
		p.over();
		p.mParent();

		Child c=new Child();
		System.out.println(c.k);
		c.over();
		c.mParent();
		c.mChild();
	}
}