package edu.jaen.java.modifier;

class StaticTest {
	static int count;

	static void setCount(int k) {
		count = k;
		System.out.println("setCount() : " + count);
	}

	//static Block -> 객체가 로딩될 때 실행 (객체가 2개 이상 있어도 1번만 실행된다.) -> 데이터베이스 connection, 라이브러리 로딩 등에 대한 코드에 사용 가능
	static {
		System.out.println("static initialize! count: " + count);
	}

	// Instance Block -> 생성자가 호출되기 전에 실행. 생성자가 없으면 실행되지 않느다.
	{
		System.out.println("instance initialize...");
	}
	
	public StaticTest() {
		System.out.println("StaticTest Constructor");
	}
	
	public StaticTest(int a) {
		System.out.println("StaticTest(int) Constructor");
	}

	public static void main(String args[]) {
//		System.out.println("Main Start!");
//		StaticTest.setCount(10);
		
		StaticTest si = new StaticTest(9);
//		System.out.println("Main...");
//		StaticTest si2 = new StaticTest();
	}
	
	
}
