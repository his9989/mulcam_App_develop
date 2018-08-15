package com.my;

public class bm_main {

	public static void main(String[] args) {
		System.out.println("*********************도서 목록*********************");
		Book b1 = new Book("21424", "Java Basic", "김하나", "Jaen.kr", 15000, "Java 기본문법");		
		System.out.println(b1.toString());
		Book b2 = new Book("33455", "JDBC Pro", "김철수", "Jaen.kr", 23000, "");		
		System.out.println(b2.toString());
		Book b3 = new Book("55355", "Servlet/JSP", "박자바", "Jaen.kr", 41000, "Model2 기반");		
		System.out.println(b3.toString());
		Book b4 = new Book("35332", "Android App", "홍길동", "Jaen.kr", 25000, "Lightweight FrameWork");		
		System.out.println(b4.toString());
		Book b5 = new Book("35355", "OOAD 분석, 설계", "소나무", "Jaen.kr", 30000, "");		
		System.out.println(b5.toString());
		System.out.println("*********************잡지 목록*********************");
		Magazine m1 = new Magazine("35535", "Java World", "편집부", "Jaen.kr", 7000, "", 2013, 2);		
		System.out.println(m1.toString());
		Magazine m2 = new Magazine("33434", "Mobil World", "편집부", "Jaen.kr", 8000, "", 2013, 8);		
		System.out.println(m2.toString());
		Magazine m3 = new Magazine("75342", "Next Web", "편집부", "Jaen.kr", 10000, "AJAX 소개", 2012, 10);		
		System.out.println(m3.toString());
		Magazine m4 = new Magazine("76543", "Architecture", "편집부", "Jaen.kr", 5000, "java 시스템", 2010, 3);		
		System.out.println(m4.toString());
		Magazine m5 = new Magazine("76534", "Data Modeling", "편집부", "Jaen.kr", 14000, "", 2012, 12);		
		System.out.println(m5.toString());
	}

}
