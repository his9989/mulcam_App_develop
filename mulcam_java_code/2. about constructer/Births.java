package edu.jaen.java;

public class Births {
	int year = 2018;
	int months = 8;
	int day = 2;

	/* Births 생성자가 3개이므로, 생성자 오버로드 한 것.*/
	
	public Births(int _year,int  _months, int _day){	//매개변수 3개의 생성자
		System.out.println("three input date");
		year=_year;
		months=_months;
		day=_day;
	}
	
	public Births(int _year, int _months0) {			//매개변수 2개의 생성자
		System.out.println("two input date");
	}
	
	public Births(String _year, int _months0) {			//매개변수 2개의 생성자
		System.out.println("two input and diffierent type date");
	}
	
	public Births() {									// 매개변수 없는 생성자
		System.out.println("Default date");
	}

	public String toString() {
		return year+"/"+months+"/"+day;
	}
}
