## 자료
1. https://docs.oracle.com/javase/10/ : java에서 제공하는 라이브러리 문서화

2. 더블클릭하고 F3누르면 선언부로 이동한다. (ex. System.out.println에서 out 더블클릭하고 F3 눌러보기)

3. ★ 빈 공간에 우클릭 -> source를 이용하면 관습적으로 사용하는 코드를 자동 생성해준다.
	* ex) 생성자        : generate constructer using field.. (밑에서 3번째)
	* toString()    : generate toString() (밑에서 4번째)
	* get, set 함수 : generate getters and setters (밑에서 7번째)
	* 기타 등등 여타 다른 코드도 자동 생성 편하게 할 수 있다.

</hr>

## 접근제한자

**접근제한자 : 클래스, 인스턴스 변수, 메소드 앞에 붙는다. 지역 변수 앞에는 못 붙는다.**

1. public: same class, same package, subclass, universe <br>
	   내가 만들었지만, 다른 사람도 사용 가능한 경우 <br>
	   대형 프로젝트에서 내 코드를 다른 사람이 사용해야 되는 경우 <br>
		-> api, 라이브러리 등 오픈 소스에서는 public 사용 <br>
		-> 잘못된 데이터를 받을 위험이 있다. <br>

2. protected: same class, same package, subclass

3. default: same class, same package <br>
	    접근제한자 설정하지 않은 경우

4. private: same class<br>
	    class에서 데이터와 메소드가 있을 때, 데이터는 잘못된 데이터가 들어오는 것을 막기위해 private로 해야한다.<br>
		(+) 보안을 위해서도 사용될 수 있다. (중요, 상세 정보는 숨겨둔다. 접근에 필요한 것들은 public으로 한다.)

</hr>

## this

* this는 method 안에서 사용할 수 있다.
* this가 가리키는 것 = method를 갖고 있는 것.
	- 현재 실행중인 객체의 위치값 	: this
	- 현재 실행중인 객체의 멤버 변수	: this.멤버변수명
	- 현재 실행중인 객체의 apthem	: this.메소드명()
	- 현재 실행중인 객체의 생성자	: this(args list)

   ex)
   
   	<code>
   
   	public class Movie(){
		public String title;
		public String director;

		public Movie(){	   이렇게 생성자 내에서
			this();	-> 생성자를 this로 부른것. 이것도 재귀함수가 된다.
		}

		public Movie(int title){
			this();			// 위의 public Movie(){this();}를 호출한다.
			this.title = title;	//this.title의 title는 class의 멤버 변수, 우변의 title는 public Movie(int title)에서 매개변수로 받은 title
						  this.title : 인스턴스 변수, 우변 title : 로컬 변수
			//this();		// 이런식으로 this로 생성자를 부를 때, 구현부 코드보다 아래있으면 에러 발생
		}

		void movieInfo(){
			this.	-> Movie 클래스 내의 멤버변수, 메소드 등을 사용할 수 있다.
				ex. this.title
				    this.director 이런식으로 사용할 수 있다.
				    심지어 this.movieInfo()를 통해 재귀함수도 가능하다.
			return title;	-> 여기서 title는 this.title를 중략한 것
		}
	}
	
	</code>
	
</hr>

## 오버로드

**생성자 오버로드 뿐 아니라, 메소드 오버로드도 가능하다.** <br>

	단, 메소드 오버로드할 때는 리턴 값은 상관없고, 인자 DT만 다르도록 하면 된다.
	
	ex. 인자를 int / double로 받는 메소드 오버로드
	
	<code>
	
		public class AddTest {
			public int add(int a, int b) {
				int res = a+b;
				return res;
			}

			public double add(double a, double b) {
				double res = a+b;
				return res;
			}
		}
		
	</code>
	
</hr>

## Encapsulation(캡슐화, 은닉화)

** Encapsulation: Access Modifier(접근 제한자)을 이용해서 캡슐화한다.**<br>
	변수는 error 발생 방지를 위해 private으로 캡슐화한다.<br>
	캡슐화된 변수는 get/set 함수를 별도로 만들어서 사용한다.<br>
	
	ex. month라는 변수는 1~12만 사용해야한다. 근데 public month로 하면, 그 외의 숫자도 사용할 수 있다.<br>
	    이 때, private month로 하고, set 함수를 만들어서 1~12인 경우에만 객체에서 month를 사용할 수 있도록 할 수 있다.<br>
	    
	-> 즉, 사용자가 class 내의 변수를 잘못된 방법으로 사용하려고 하더라도 프로그래머가 변수는 private로 보호하고, <br>
	   이 변수를 사용하기 위한 조건 등을 get/set함수를 이용해서 만들어준다.<br>
	   사용자가 잘못 사용하려고 해도, 함수 내의 기능에 의해 사용하지 못하도록 한다.<br>

	입력: set
	출력: get
	
</hr>

## api : application programming interface
1. 기본 api
	* java.io : 입출력
	* java.lang : 기본 클래스 제공 (math, thread 등 포함)
	* java.net : 네트워크 관련
	* java.sql : DB
	* java.text : 문자열 포멧 관련
	* java.util : 자료 관리에 사용

2. 사용자 정의 api

	사용자 정의 라이브러리도 만들 수 있다. <br>

	라이브러리 만들고자 하는 패키지에서 우클릭 -> Export해서 배경화면에 jar 파일 만들기. <br>

	-> 자체적으로 만든 라이브러리 사용할 때는, 사용하고자 하는 폴더에 드래그로 넣기.

</hr>

## array (다음 파일 참고)

**array는 reference data type으로 new을 이용해서 객체로서 선언해야한다.** <br>
	
		ex) int []iarr = new int[5];
				
			* int형의 배열타입 iarr의 시작 주소(0xF..)는 stack에 저장된다.
			* int형의 배열타입 iarr의 원소(iarr[0], iarr[1], ... , iarr[4])는 heap에 저장된다.
