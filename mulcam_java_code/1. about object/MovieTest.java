package edu.jaen.java;

public class MovieTest {

	public static void main(String[] args) {
		Movie m = new Movie();						// Movie class�� ��ü�� �������. m���� title���� movieInfo()������ ������ �޼ҵ尡 ��� ����ְ� �Ǿ���.
		m.title = "�ظ�����";
		m.director = "���̺� ������";
		m.grade = 5;
		m.genre = "��Ÿ��";
		m.summary = "�����б� ���ġ ����";				
		m.movieInfo();
		String writer = m.toString();
		System.out.println("write by " + writer);
	}
}
