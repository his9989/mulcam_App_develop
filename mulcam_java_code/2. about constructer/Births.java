package edu.jaen.java;

public class Births {
	int year = 2018;
	int months = 8;
	int day = 2;

	/* Births �����ڰ� 3���̹Ƿ�, ������ �����ε� �� ��.*/
	
	public Births(int _year,int  _months, int _day){	//�Ű����� 3���� ������
		System.out.println("three input date");
		year=_year;
		months=_months;
		day=_day;
	}
	
	public Births(int _year, int _months0) {			//�Ű����� 2���� ������
		System.out.println("two input date");
	}
	
	public Births(String _year, int _months0) {			//�Ű����� 2���� ������
		System.out.println("two input and diffierent type date");
	}
	
	public Births() {									// �Ű����� ���� ������
		System.out.println("Default date");
	}

	public String toString() {
		return year+"/"+months+"/"+day;
	}
}
