package edu.jaen.java.modifier;
class StaticVarTest {
	
	static int count=0;	//static변수는 객체들간 공유되는 변수이다.
	int b=0;     		//instance Variable, member variable
	
	void run(){
		//local variable
		int num = 0;
		count++;
		b++;
		num++;
		System.out.println("count="+count+"\tb="+b+"\tnum="+num);
	}
	public static void main(String[] args) {
		System.out.println("StaticVarTest.count="+StaticVarTest.count);
		StaticVarTest a1 = new StaticVarTest();
		StaticVarTest a2 = new StaticVarTest();
		a1.run();
		a2.run();
		a1.b +=100;
		a1.count += 100;
		System.out.println("a1.count="+a1.count+" b="+a1.b);
		System.out.println("a2.count="+a2.count+" b="+a2.b);
		System.out.println("StaticVarTest.count="+StaticVarTest.count);
	}
}