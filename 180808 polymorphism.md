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
      - static Block : 객체가 로딩될 때 실행 <br>
                       즉, 객체가 2개 이상 있어도 1번만 실행된다. <br>
                          -> 데이터베이스 connection, 라이브러리 로딩 등에 대한 코드에 사용 가능
                          
      - instance Block : 생성자가 호출되기 전에 실행. 생성자가 없으면 실행되지 않느다.

  * final : 마지막을 의미한다. 메소드/클래스/변수 앞에 붙을 수 있으며, 이들이 변경될 수 없도록 한다.
      - final class : 상속받을 수 없다.를 의미
      - final method : Override 할 수 없다.를 의미
      - final variable : 상수로 정의. 즉, 변수의 값을 변경할 수 없다.
      
      
## 조퇴. interface 내용 못 들었다.


------
+ 이전 내용 추가
생성자: 객체를 생성할 때 실행
