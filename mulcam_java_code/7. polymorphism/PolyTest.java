package edu.jaen.java.polymorphism;
class PolyTest 
{
	public static void main(String[] args) 
	{
		Customer c = new Customer("ȫ�浿", "����", 20);
		MainCustomer mc = new MainCustomer("�ҳ���", "�λ�", 21, "drum");
		
		Customer cc=new MainCustomer("������","��õ",25,"����");		// Polymorphism
																// UpCasting�̹Ƿ� new ���� (Customer) ���� ����
//		MainCustomer mc2 = (MainCustomer) new Customer();		// ������ ������ ���µ�, ����� ��Ÿ�� ������ �߻��Ѵ�.
		
		Customer[] arrc = new Customer[2];
		MainCustomer[] arrm = new MainCustomer[2];
		
		arrc[0] = c;
		arrc[1] = cc;

		arrm[0] = mc;
//		arrm[1] = mc2;
		
		MainCustomer[] arrmm = new MainCustomer[10];
		
		arrmm[0] = mc;
//		arrmm[1] = mc2;
//		arrmm[2] = c;			// super�� Customer Ÿ���� c�� sub�� MainCustomer�� �������� �ؼ� ���� �߻�!
//		arrmm[3] = cc;
		
		LiteCustomer lc = new LiteCustomer();
		VipCustomer vc = new VipCustomer();
		SubLiteCustomer slc = new SubLiteCustomer();
		Customer[] arrcc = new Customer[10];
		
		arrcc[0] = c;
		arrcc[1] = cc;
		arrcc[2] = mc;			// sub�� MainCustomer Ÿ���� mc�� super�� Customer�� �������� �ؼ� ����!
//		arrcc[3] = mc2;
		arrcc[4] = lc;
		arrcc[5] = vc;
								// sub�� super���� ū �����̴�.
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
	
	public static void printCustomer(Customer c) {		// ���� �Ʒ��� 3���� �־�� �ϴµ�, Customer �ϳ��� �־ Ŀ�� ����
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
