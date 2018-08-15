package edu.jaen.java.polymorphism;
class PolyTest 
{
	public static void main(String[] args) 
	{
		Customer c = new Customer("홍길동", "서울", 20);
		MainCustomer mc = new MainCustomer("소나무", "부산", 21, "drum");
		
		Customer cc=new MainCustomer("강나루","인천",25,"게임");		// Polymorphism
																// UpCasting이므로 new 앞의 (Customer) 생략 가능
//		MainCustomer mc2 = (MainCustomer) new Customer();		// 컴파일 에러는 없는데, 실행시 런타임 에러가 발생한다.
		
		Customer[] arrc = new Customer[2];
		MainCustomer[] arrm = new MainCustomer[2];
		
		arrc[0] = c;
		arrc[1] = cc;

		arrm[0] = mc;
//		arrm[1] = mc2;
		
		MainCustomer[] arrmm = new MainCustomer[10];
		
		arrmm[0] = mc;
//		arrmm[1] = mc2;
//		arrmm[2] = c;			// super인 Customer 타입의 c를 sub인 MainCustomer에 넣으려고 해서 에러 발생!
//		arrmm[3] = cc;
		
		LiteCustomer lc = new LiteCustomer();
		VipCustomer vc = new VipCustomer();
		SubLiteCustomer slc = new SubLiteCustomer();
		Customer[] arrcc = new Customer[10];
		
		arrcc[0] = c;
		arrcc[1] = cc;
		arrcc[2] = mc;			// sub인 MainCustomer 타입의 mc를 super인 Customer에 넣으려고 해서 가능!
//		arrcc[3] = mc2;
		arrcc[4] = lc;
		arrcc[5] = vc;
								// sub이 super보다 큰 개념이다.
		Object[] obj = new Object[10];
		obj[0] = 1;
		obj[1] = 1.1;
		obj[2] = "Hello";
		obj[3] = new Customer();
		obj[4] = new PolyTest();
	
		printCustomer(mc);
		printCustomer(lc);
		printCustomer(vc);
		printCustomer(c);
		
		toStringCustomer(mc);
		toStringCustomer(lc);
		toStringCustomer(vc);
		toStringCustomer(c);
		toStringCustomer(slc);

	}
	
	public static void toStringCustomer(Customer c) {
		System.out.println(c.toString());
	}
	
	public static void printCustomer(Customer c) {		// 원래 아래의 3개도 있어야 하는데, Customer 하나만 있어도 커버 가능
		if(c instanceof VipCustomer) {
			VipCustomer vc = (VipCustomer)c;
			System.out.println("VipCustomer");
		}
		else if(c instanceof LiteCustomer) {
			LiteCustomer lc = (LiteCustomer)c;
			System.out.println("LiteCustomer");
		}
		else if(c instanceof MainCustomer) {
			MainCustomer mc = (MainCustomer)c;
			System.out.println("MainCustomer");
		}
		else {
			System.out.println("Just Customer");
		}
	}
//	public static void printCustomer(LiteCustomer c) {
//		System.out.println(c.getName());
//	}
//	public static void printCustomer(VipCustomer c) {
//		System.out.println(c.getName());
//	}
//	public static void printCustomer(MainCustomer c) {
//		System.out.println(c.getHobby());
//	}
}
