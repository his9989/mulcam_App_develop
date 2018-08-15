package edu.jaen.java.inter;
interface Trans{
	abstract void start();  //���� : public abstract void start();
	abstract void stop();			//���� : public abstract void stop();
}
class Bus implements ITrans{
	public void start(){
		System.out.println("start...");
	}
	public void stop(){
		System.out.println("Stop...");
	}
}
class InterfaceTest{
	public static void main(String[] a){
		ITrans t=new Bus();
		t.start();
		t.stop();
	}
};
