package edu.jaen.java;

public class Date {
	private int year = 2017;
	private int month = 12;
	private int day = 1;

	public void set_year(int _year) {
		if (_year > 2100) {
			System.out.println("Error");
			return ;
		}
		this.year = _year;
	}

	public int get_year() {
		return this.year;
	}
	
	public void set_month(int _month) {
		if(_month<1 || _month>12) {
			System.out.println("Error");
			return ;
		}
		this.month = _month;
	}
	
	public int get_month() {
		return this.month;
	}
	
	public void set_day(int day) {		
		if(day<1||day>31) {
			System.out.println("Error");
			return ;
		}
		this.day = day;
	}
	
	public int get_day() {
		return this.day;
	}
	
	public Date() {};
	public Date(int year, int month, int day) {
		set_year(year);
		set_month(month);
		set_day(day);
	}

	public String toString() {
		return year + ", " + month + ", " + day;
	}
}
