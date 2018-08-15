package edu.jaen.java.modifier;

abstract class Trans {
//	선언부,호출부는 있는데 구현부{}가 없는 method= 추상 method
	abstract void start();

	abstract void stop();
	
	public void cdPlay(){
		System.out.println("음악이 나옵니다.");
	}

}
//	추상 class를 상속 받기 위해서는 1.추상 class로 만들거나 2.method override로 구현부 생성함
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
//		추상클래스에 추상method가 없어도 객체화 되지 않는다 / 상위 클래스 용도로만 사용
//		AbsTest a = new AbsTest();
		AbstTest b = new AbstSub();
		b.printTest();
//		추상클래스는 직접 객체화 될 수 없다.
//		Trans t1 =new Trans();
//		upcasting 가능  override
		Trans t = new Bus();
		t.start();
		t.stop();
		t.cdPlay();
	}
};
