package edu.jaen.java;

public class DateMain {
	public static void main(String[] args) {
		Date d = new Date();
		Date d2 = new Date(2018, 01, 24);
		
//		d.year = 2018;
//		d.month = 17;
//		d.day=10;
		
		d.set_year(2013);
		d.set_month(11);
		d.set_day(30);

		System.out.println(d.toString());
		System.out.println(d2.toString());
	}
}