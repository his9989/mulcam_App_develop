package edu.jaen.java;							//같은 package의 customer.java를 사용할 수 있다. (?)
class CustomerTest								//프로그램 실행 용도의 class. java는 객체 지향이므로, 굳이 class로 객체화 해줌. class 밖에서는 어떤 코드도 작성 불가
{
	public static void main(String[] args) 
	{
		Customer cu=new Customer();				//customer이라는 class를 틀로 해서 cu라는 객체를 찍어낸다.
		cu.name="홍길동";							//cu라는 객체의 name 변수에 "홍길동"저장
		cu.address="서울";						
		cu.age=20;
		cu.customerInfo();						//객체의 customerInfo method 실행부
		
		Customer cu2=new Customer();			//Customer는 class, cu2는 객체 Customer class 틀을 따르지만, cu2는 자유롭게 바뀔 수 있다.
		cu2.name = "둘리";
		cu2.age=7;
		cu2.address="쌍문동";
		cu2.customerInfo();
	}
}