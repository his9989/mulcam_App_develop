package edu.jaen.java.modifier;

class StaticTest {
	static int count;

	static void setCount(int k) {
		count = k;
		System.out.println("setCount() : " + count);
	}

	//static Block -> ��ü�� �ε��� �� ���� (��ü�� 2�� �̻� �־ 1���� ����ȴ�.) -> �����ͺ��̽� connection, ���̺귯�� �ε� � ���� �ڵ忡 ��� ����
	static {
		System.out.println("static initialize! count: " + count);
	}

	// Instance Block -> �����ڰ� ȣ��Ǳ� ���� ����. �����ڰ� ������ ������� �ʴ���.
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
