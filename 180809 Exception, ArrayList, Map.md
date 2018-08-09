## 자료
자바 document
    * https://www.oracle.com/index.html 접속
    * menu-documentation-Java-Java SE documentation
    * JDK 9, 8, 7, ... 다른 버전의 documentation도 확인 가능
        -> 여기서 기본 라이브러리에 대한 설명을 볼 수 있다.
        
## 단축키, 참고
1. 메소드나 함수 등을 누르고 **F3** 을 누르면 source로 이동한다.

2. 아래의 코드와 같이 "throws xxxException"이라고 코딩을 하면 "에러 발생시, 이 객체가 호출된 코드 부분에 xxxException을 던지겠다"라는 의미이다.

<code>
	
	public FileReader(String fileName) throws FileNotFoundException {
		super(new FileInputStream(fileName));
	}

</code>

## object (Java.lang)
1. toString : 객체를 대표하는 문자열을 return. String 타입

2. hashcode : 객체를 구분하는 코드값을 return. int 타입

  * hashcode : 객체의 메모리 값에 따라 만들어지므로, object 통째로 하는 것 보다 member를 하나씩 하는게 좋다.
  
  * hashcode가 사용되는 아주 간단한 경우

       문자열을 비교하고자 하고 <br> 
          str1="Hello" <br>
          str2="Hello" 일 때 <br>
       str1 == str2 -> false가 된다. <br>
       -> 이럴 때, 해쉬코드를 사용하면 원하는 논리결과를 얻을 수 있다. <br>
       
3. equals : 객체 내용을 비교할 수 있도록 구현. boolean 타입

## String 클래스 (Java.lang)

<code>
   
       /***** 새로운 문자열 생성 *****/
    String c1 = str.concat("AAA"); //문자열 연결 ' +' 와 같다.
	if (str==c1)
	   System.out.println("str==c1");
	String c2 = str.replace('T', 'O'); //문자열에 있는 특정문자를 다른문자로 치환
    String c3 = str.substring(2,5); //문자열중 일부 추출
    String c4 = str.toLowerCase(); //모든 문자를 소문자로바꿈
    String c5 = str.toUpperCase(); //모든 문자를 대문자로 바꿈
    String c6 = str.trim(); //문자열의 앞뒤 여백을 제거
                
    boolean s1 = str.endsWith("String "); // 특정문자열로 끝나는지의 여부
    boolean s2 = str.startsWith(" This"); //특정 문자열로 시작하는 지의 여부
    int s3 = str.indexOf('i'); //특정문자가 처음 나타나는 위치
    int s4 = str.indexOf('i', s3+1); //특정문자가 두번째 나타나는 위치
    int s5 = str.lastIndexOf('i', s4-1); //특정문자가 두번째 나타나는 위치에서 역순으로 검색
                                
    /***** comparsion *****/
    boolean p1 = str.equals(" This is a String "); //문자열 비교
    boolean p2 = str.equalsIgnoreCase(" this is a string "); //대소문자 구별없이 문자열 비교
    int p3 = str.compareTo(" String "); //알파벳의 순서 비교
              
    /***** others *****/
    char o1 = str.charAt(2); //특정위치의 문자
    int o2 = str.length(); //문자열 길이

</code>

   *  StringBuilder의 효율성
   
      - 일반적인 문자열 합치기. 결과: 2564.0
      - StringBuilder의 append 사용. 결과: 1.0

<code>

      double start = System.currentTimeMillis();
	   String s =new String();
      for(int i=0; i<100000; i++) {
         s+="a";
      }
      double end = System.currentTimeMillis();
      System.out.println("Excute Time : " + (end-start));

</code>

<code>
   
      StringBuilder str = new StringBuilder();
		start = System.currentTimeMillis();
		for(int i = 0; i<100000; i++) {
			str.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println("Excute Time : " + (end-start));
      
</code>

## Wrapper class

   * Warpper : Java의 기본형 데이터 타입을 객체화 시키는 클래스.
   
   * 문자열에서 숫자로 변환

<code>
   int aa = Integer.parseInt("123456");
</code>

   * 숫자에서 문자로 변환

<code>
   st = String.valueOf(a);
   st=a+"";
</code>

## Map

<code>
	
	class Cal{
	private static Cal c = new Cal();
	public static Cal getInstance() {
		return c;
	}
	private Cal() {
		// 초기화 여러 작업들을 미리 설정하며
		// 또한 만들어지는 객체의 수를 제한할 수 있습니다.
	}

	public class CurrentTime {
		static public  void main(String args[]){
 			Calendar rightNow = Calendar.getInstance(); // Calendar a = new Calendar();
 			Cal c = Cal.getInstance(); 
 			Cal c2 = Cal.getInstance();
 				//-> c, c2는 같은 객체다. 원래는 이런식으로 하면 서로 다른 객체를 만들게 되어 있는데, 위에서 싱글 머시기 작업으로 객체의 수를 제한하였다.
	}
	
</code>

## Callendar

* Callendar : 다른건 안그러는데 월은 0부터 시작한다

<code>
	
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
		
</code>

## ArrayList
* ArrayList 코드, 기능 : 배열같이 생겼지만, 사실 상 배열은 아니다. 

* 입력이 배열 크기 꽉 찰 때, 배열 크기를 늘려주는 코드

<code>
	
	private int max = 10;
	private Object[] objs = new Object[max];
	private int index;
	
	public void add(Object o) {
		if(index>=0 && index<objs.length) {
			objs[index] = o;
			index++;
		} else {
			max *= 2;
			Object[] tmp = new Object[max];
			System.arraycopy(objs, 0, tmp, 0, objs.length);
			objs = tmp;
			objs[index] = o;
			index++;
		}
		
	}
	
</code>

## Exception, try/catch

* if/else로 예외처리 하는 경우, 매 번 조건문을 실행해서 비효율 적이다.

* try/catch는 에러 발생시 자동으로 예외처리로 넘어가는 문법으로, 예외처리에 훨씬 효율적이다.

	1. try : 예외가 발생할 수 있는, 기본적인 실행 코드
	
	2. catch(xxxException e) : xxxException이 발생했을 떄 실행할 예외 처리 코드. <br>
				   여러 예외에 대해 대비할 수 있다. (아래 코드는 2가지)
	
	3. finally : 예외처리까지 모두 마무리 된 후, 마지막에는 무조건 붙여서 실행시키고 싶은 코드
<code>

	package edu.jaen.java.basic;

	import java.util.Scanner;

	class Customer {}

	public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("두 개의 정수를 입력하세요");
		int a = s.nextInt();
		int b = s.nextInt();
		
		// 예외 발생을 위해 만든 객체
		Customer c = null;	// NullPointerException 발생
		Customer c2 = new Customer();
		
		try {
			// 예외 발생 가능 문장
			int res = a / b;
			c2.toString();
			System.out.println(a + " / " + b + " = " + res);
		} catch(ArithmeticException e) {
			// 예외1 발생 시 복구 코드
			System.out.println("ArithmeticException");
			System.out.println("b must bigger than zero");
		} catch(NullPointerException e) {
			// 예외2 발생 시 복구 코드
			System.out.println("NullPointerException");
		} finally {
			System.out.println("프로그램 종료!");
		}
		
		if(b>0) {// 이런 예외 상황 체크를 조건문 말고, try/catch 방법으로 실행해라.
			int res = a / b;
			System.out.println(a + " / " + b + " = " + res);
		} else {
			// 이런 예외 상황을 코드로 하지말고 객체(class)로 동작시켜라.
			System.out.println("b must bigger than zero");
		}
</code>

## Exception throws

* 메소드를 실행할 때 error를 발생시키게 하는 방법. main에서 해당 메소드를 실행할 때 예외처리하도록 하는데 사용된다.

<code>
	
	public void sayNick(String nick) throws FoolException {
		if ("fool".equals(nick)){
			throw new FoolException();
		}
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		try{
			test.sayNick("fool");
		} catch(FoolException e){
			System.out.println("FoolException이 발생하였습니다.");
		}
	}
	
</code>
