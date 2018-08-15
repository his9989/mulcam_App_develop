package edu.jaen.java;
//* 영화 정보 클래스 */
public class Movie {
	//* 제목 */
	public String title;
	//* 김독*/
	public String director;
	//* 등급*/
	public int grade;
	//* 장르*/
	public String genre;
	//* 내용 */
	public String summary;
	
	public Movie() {}
	
	public Movie(String title) {
		this();					// public Movie(){}를 호출한다. 아무일도 없다.
		this.title=title;
	}
	
	//* 출력 함수 */
	public void movieInfo() {
		System.out.println(title);
		System.out.println(director);
		System.out.println(grade);
		System.out.println(genre);
		System.out.println(summary);
	}
	
	//* 문자열 반환 함수 */
	public String toString() {
		return "한인수";
	}
}
