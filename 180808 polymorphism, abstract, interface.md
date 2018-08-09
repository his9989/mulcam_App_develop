## Polymorphism 

1. Use modifier
    (Modifier는 user와 access로 나뉜다. access modifier = private, public, ... )

  **Use Modifier : static, final, abstract**
  
  * static
    class member variables, class member method, class sub member 앞에 사용한다.
    outer class(외부 클래스)에는 못 붙는다.
    
      - static변수
        객체들간 공유되는 변수이다. <br>
        즉, 서로 다른 객체에서 변수 값을 변형하더라도, 전역변수처럼 일괄되게 반영되는 것
    
      - static 함수
        static 함수 내에서는 static 변수나 메소드만 호출이 가능하다. <br>
        즉, 아래와 같은 경우, setCount는 static 함수인데, a는 아니므로, setCount에서는 a를 사용할 수 없다. <br>
        setCount의 static를 지우거나, static int a로 하면 error가 사라진다.
    
ex)

<code>

	int a;

	static void setCount(int k) {
		a=5;
 	}
    
</code>

  * block : {}만을 이용해서 코드를 구현한 것. static과 Instance로 나뉜다.
      - static Block : 객체가 로딩될 때 실행. main보다도 먼저 실행된다. <br>
                       즉, 객체가 2개 이상 있어도 1번만 실행된다. <br>
                          -> 데이터베이스 connection, 라이브러리 로딩 등에 대한 코드에 사용 가능
                          
      - instance Block : 객체를 만들 때 생성자보다 먼저 실행된다. <br>
      			 생성자가 호출되기 전에 실행. 생성자가 없으면 실행되지 않느다.

  * final : 마지막을 의미한다. 메소드/클래스/변수 앞에 붙을 수 있으며, 이들이 변경될 수 없도록 한다.
      - final class : 상속받을 수 없다.를 의미
      - final method : Override 할 수 없다.를 의미
      - final variable : 상수로 정의. 즉, 변수의 값을 변경할 수 없다.
      
  * abstract : 밑에서 설명
  
  * interface : 밑에서 설명
  
      
## abstract

  * method, class에 붙을 수 있다.
  * 메소드 정의만 하고, 구현은 하지 않는 경우에 사용한다.
  * 즉, super class에서 메소드 정의만 해주고, sub class에서 overriding을 통해 메소드 내용을 구현해서 가져다 쓰는것. 
  * 이름을 공통적으로 사용하는데 사용하는 듯 하다. 
  * method 앞에 abstract를 붙여서 추상 메소드를 선언 가능. 추상 메소드를 갖는 클래스는 abstract class 형식의 추상클래서여야한다.

<code>
	
	abstract class Trans {			// 추상 클래스
		abstract void start();		// 추상 메소드
		abstract void stop();		// 추상 메소드
	}
	
</code>
		


**abstract 특징**

  1. 추상 클래스는 객체화 할 수 없다. 즉, 힙 영역에 올라갈 수 없으며, 아래와 같이 사용이 불가능하다.
		
<code>
	
	class AbstractTest{
		public static void main(String[] args){
			Trans t = new Trans();
		}
	}
	
</code>

  2. 추상 클래스는 super class로서 주로, 틀을 만들 때 사용된다. (interface와 비슷하지만 다르다)
  
  3. sub class는 추상 클래스의 모든 추상 메소드를 overriding해야 사용 가능하다. (아니면 에러뜬다)
		
<code>
	
	class Bus extends Trans{
		@override
		void start() {System.out.println("start overriding!");}
		@override
		void stop() {System.out.println("stop overriding!");}
	
</code>

  4. 추상 클래스는 일반 메소드를 가질 수 없다.
		
## interface

  * 상수와 구현되지 않은 추상 메소드로만 구성된다.
  * 변수를 가질 수 없다. (자동으로 상수화된다.)
  * 인터페이스의 모든 메서드는 자동으로 컴파일러가 public static final 제한자를 삽입한다.

	ex)
	
<code>
	
	interface MyInterface{
		int THIRD = 3;
	}
	
	public class YourInterface{
		final int THIRD = 3;
      }
      
</code>
		-> 위와 같은 경우, 두 개의 THIRD 모두 같은 상수 3이 된다.
		
**interface의 특징**

  1. 객체 생성 불가. (구현되지 않은 메소드를 갖고 있다)
  
  2. super type으로 사용한다.
  
  3. interface 내에 변수를 넣으면 상수가 되고, 메소드를 넣으면 추상메소드가 된다.
  
  4. sub class가 모든 메소드를 구현해야하며, interface는 영수증 같은 역할을 한다. (sub class가 이거이걸 했어~)
  
  5. Polymorphism 효과를 보인다.
  
  6. interface를 상속할 때는 extends 대신에 implements를 사용한다.
  
  7. interface는 다중 상속이 가능하다. ( implements interface1, interface2 )
  
  8. upcasting이 가능핟.


## abstract와 interface의 차이점

* abstract가 사용되는 환경
	1. 관련성 높은 클래스들에게 공통적으로 필요한 특정 속성/메소드
	2. 다양한 접근 제한자를 사용하는 경우
	3. 일반 속성을 선언하고 사용하려는 경우
	
* interface가 사용되는 환경
	1. 관련성 없는 클래스들에게 공통적으로 필요한 특정 속성/메소드
	2. 관련성 없는 클래스 사이에 상수가 공유될 필요가 있는 경우
	3. 다중 상속을 
