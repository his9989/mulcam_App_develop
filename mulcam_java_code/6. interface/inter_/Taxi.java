package edu.jaen.java.inter;

//인터페이스는 implements로 상속
public class Taxi extends Machine implements ITrans, Imusic {
	@Override
	public void onoff() {
		// TODO Auto-generated method stub
		super.onoff();
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Taxi가 출발합니다.");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Taxi가 정차합니다.");

	}

	@Override
	public void MusicPlay() {
		// TODO Auto-generated method stub
		System.out.println("택시에 음악이 나와용~");
	}

}
