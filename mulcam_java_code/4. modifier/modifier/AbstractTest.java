package edu.jaen.java.modifier;
abstract class Trans{
	abstract void start();
	abstract void stop();
}
class Bus extends Trans{
	public void start(){
		System.out.println("start...");
	}
	public void stop(){
		System.out.println("Stop...");
	}
}
class AbstractTest{
	public static void main(String[] a){
		Trans t=new Bus();
		t.start();
		t.stop();
	}
};
