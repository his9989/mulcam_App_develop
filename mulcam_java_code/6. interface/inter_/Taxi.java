package edu.jaen.java.inter;

//�������̽��� implements�� ���
public class Taxi extends Machine implements ITrans, Imusic {
	@Override
	public void onoff() {
		// TODO Auto-generated method stub
		super.onoff();
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Taxi�� ����մϴ�.");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Taxi�� �����մϴ�.");

	}

	@Override
	public void MusicPlay() {
		// TODO Auto-generated method stub
		System.out.println("�ýÿ� ������ ���Ϳ�~");
	}

}
