package edu.jaen.java.modifier;

abstract class Trans {
//	�����,ȣ��δ� �ִµ� ������{}�� ���� method= �߻� method
	abstract void start();

	abstract void stop();
	
	public void cdPlay(){
		System.out.println("������ ���ɴϴ�.");
	}

}
//	�߻� class�� ��� �ޱ� ���ؼ��� 1.�߻� class�� ����ų� 2.method override�� ������ ������
class Bus extends Trans {
	@Override
	public void start() {
		System.out.println("start...");
	}
	@Override
	public void stop() {
		System.out.println("Stop...");
	}
}

abstract class AbstTest{
	public void printTest() {
		System.out.println("Test======");
	}
}

class AbstSub extends AbstTest{
	
}
class AbstractTest {
	public static void main(String[] a) {
//		�߻�Ŭ������ �߻�method�� ��� ��üȭ ���� �ʴ´� / ���� Ŭ���� �뵵�θ� ���
//		AbsTest a = new AbsTest();
		AbstTest b = new AbstSub();
		b.printTest();
//		�߻�Ŭ������ ���� ��üȭ �� �� ����.
//		Trans t1 =new Trans();
//		upcasting ����  override
		Trans t = new Bus();
		t.start();
		t.stop();
		t.cdPlay();
	}
};
