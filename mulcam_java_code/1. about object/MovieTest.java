package edu.jaen.java;

public class MovieTest {

	public static void main(String[] args) {
		Movie m = new Movie();						// Movie class의 객체를 만들었다. m에는 title부터 movieInfo()까지의 변수와 메소드가 모두 들어있게 되었다.
		m.title = "해리포터";
		m.director = "데이벳 예이츠";
		m.grade = 5;
		m.genre = "판타지";
		m.summary = "마법학교 양아치 졸작";				
		m.movieInfo();
		String writer = m.toString();
		System.out.println("write by " + writer);
	}
}
