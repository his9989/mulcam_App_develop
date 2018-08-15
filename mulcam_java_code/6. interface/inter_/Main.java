package edu.jaen.java.inter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		인터페이스는 객체화 될 수 없다. 
//		ITrans i =new ITrans();
		Taxi t =new Taxi();
		Machine t1 =new Taxi();
		Imusic t2 =new Taxi();
		ITrans t3 =new Taxi();
		
		t.MusicPlay();
		t1.onoff();
		t2.MusicPlay();
		t3.start();
	}

}
