package edu.jaen.java.util;
import java.util.*;

class Cal{
	private static Cal c = new Cal();
	public static Cal getInstance() {
		return c;
	}
	private Cal() {
		// �ʱ�ȭ ���� �۾����� �̸� �����ϸ�
		// ���� ��������� ��ü�� ���� ������ �� �ֽ��ϴ�.
	}
}

public class CurrentTime {
	static public  void main(String args[]){
 		Calendar rightNow = Calendar.getInstance();
 		// Calendar a = new Calendar();
 		Cal c = Cal.getInstance(); 
 		Cal c2 = Cal.getInstance();
 			//-> c, c2�� ���� ��ü��. ������ �̷������� �ϸ� ���� �ٸ� ��ü�� ����� �Ǿ� �ִµ�, ������ �̱� �ӽñ� �۾����� ��ü�� ���� �����Ͽ���.
 		
		int hour = rightNow.get(Calendar.HOUR);
		int min = rightNow.get(Calendar.MINUTE);
		int sec = rightNow.get(Calendar.SECOND);
 		int year = rightNow.get(Calendar.YEAR);
		int month = rightNow.get(Calendar.MONTH);
		int date = rightNow.get(Calendar.DATE);
		System.out.println("���� �ð��� " + year + "�� " + 
                (month+1) + "�� " + date + "��");
		System.out.println("���� �ð��� " + hour + "�� " + 
                min + "�� " + sec + "��");

	}
}
