package edu.jaen.java;
//* ��ȭ ���� Ŭ���� */
public class Movie {
	//* ���� */
	public String title;
	//* �赶*/
	public String director;
	//* ���*/
	public int grade;
	//* �帣*/
	public String genre;
	//* ���� */
	public String summary;
	
	public Movie() {}
	
	public Movie(String title) {
		this();					// public Movie(){}�� ȣ���Ѵ�. �ƹ��ϵ� ����.
		this.title=title;
	}
	
	//* ��� �Լ� */
	public void movieInfo() {
		System.out.println(title);
		System.out.println(director);
		System.out.println(grade);
		System.out.println(genre);
		System.out.println(summary);
	}
	
	//* ���ڿ� ��ȯ �Լ� */
	public String toString() {
		return "���μ�";
	}
}
