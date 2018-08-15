package edu.jaen.java.util;
import java.util.*;

class Cal{
	private static Cal c = new Cal();
	public static Cal getInstance() {
		return c;
	}
	private Cal() {
		// 초기화 여러 작업들을 미리 설정하며
		// 또한 만들어지는 객체의 수를 제한할 수 있습니다.
	}
}

public class CurrentTime {
	static public  void main(String args[]){
 		Calendar rightNow = Calendar.getInstance();
 		// Calendar a = new Calendar();
 		Cal c = Cal.getInstance(); 
 		Cal c2 = Cal.getInstance();
 			//-> c, c2는 같은 객체다. 원래는 이런식으로 하면 서로 다른 객체를 만들게 되어 있는데, 위에서 싱글 머시기 작업으로 객체의 수를 제한하였다.
 		
		int hour = rightNow.get(Calendar.HOUR);
		int min = rightNow.get(Calendar.MINUTE);
		int sec = rightNow.get(Calendar.SECOND);
 		int year = rightNow.get(Calendar.YEAR);
		int month = rightNow.get(Calendar.MONTH);
		int date = rightNow.get(Calendar.DATE);
		System.out.println("현재 시간은 " + year + "년 " + 
                (month+1) + "월 " + date + "일");
		System.out.println("현재 시간은 " + hour + "시 " + 
                min + "분 " + sec + "초");

	}
}
