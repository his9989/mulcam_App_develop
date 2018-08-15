package edu.jaen.java.inter;

public interface ITrans {
//	final이라 초기화
	int data=100;
	String name="hong";
	
//	구현부를 만들면안됨
	public abstract void start();
	void stop() ;
	

	
}
