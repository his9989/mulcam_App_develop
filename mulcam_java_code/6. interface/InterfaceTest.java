package edu.jaen.java.inter;
interface Trans{
	abstract void start();  //���� : public abstract void start();
	void stop();			//���� : public abstract void stop();
}
class Bus implements Trans{
	public void start(){
		System.out.println("start...");
	}
	public void stop(){
		System.out.println("Stop...");
	}
}
class InterfaceTest{
	public static void main(String[] a){
		Trans t=new Bus();
		t.start();
		t.stop();
	}
};
