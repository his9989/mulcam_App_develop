package com.my;

public class bm_main {

	public static void main(String[] args) {
		System.out.println("*********************���� ���*********************");
		Book b1 = new Book("21424", "Java Basic", "���ϳ�", "Jaen.kr", 15000, "Java �⺻����");		
		System.out.println(b1.toString());
		Book b2 = new Book("33455", "JDBC Pro", "��ö��", "Jaen.kr", 23000, "");		
		System.out.println(b2.toString());
		Book b3 = new Book("55355", "Servlet/JSP", "���ڹ�", "Jaen.kr", 41000, "Model2 ���");		
		System.out.println(b3.toString());
		Book b4 = new Book("35332", "Android App", "ȫ�浿", "Jaen.kr", 25000, "Lightweight FrameWork");		
		System.out.println(b4.toString());
		Book b5 = new Book("35355", "OOAD �м�, ����", "�ҳ���", "Jaen.kr", 30000, "");		
		System.out.println(b5.toString());
		System.out.println("*********************���� ���*********************");
		Magazine m1 = new Magazine("35535", "Java World", "������", "Jaen.kr", 7000, "", 2013, 2);		
		System.out.println(m1.toString());
		Magazine m2 = new Magazine("33434", "Mobil World", "������", "Jaen.kr", 8000, "", 2013, 8);		
		System.out.println(m2.toString());
		Magazine m3 = new Magazine("75342", "Next Web", "������", "Jaen.kr", 10000, "AJAX �Ұ�", 2012, 10);		
		System.out.println(m3.toString());
		Magazine m4 = new Magazine("76543", "Architecture", "������", "Jaen.kr", 5000, "java �ý���", 2010, 3);		
		System.out.println(m4.toString());
		Magazine m5 = new Magazine("76534", "Data Modeling", "������", "Jaen.kr", 14000, "", 2012, 12);		
		System.out.println(m5.toString());
	}

}
