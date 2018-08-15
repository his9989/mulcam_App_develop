package com.my.dispatch;

import java.util.Scanner;

import com.my.vo.Book;

import com.my.vo.Magazine;

/** �������� ���α׷�
 * @author student
 * ���: �Է�, ����, ����, ��ȸ, �˻�, ����
 * ���� -> �ݺ� {���(����) -> ���� -> ����} -> ����
 */

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int index = 0;
		Book[] books = new Book[10];
		Scanner s = new Scanner(System.in);
		BookTest bt = new BookTest();
		int input=0;
		boolean flag = true;
		while(flag) {
			System.out.println("================================");
			System.out.println("1.��ȸ  2.�Է�  3.����  4.����  5.�˻�  6.����");
			System.out.println("================================");
			input = s.nextInt();
			
			switch (input) {
			case 1:
				bt.list(books, index);
				break;
			case 2:
				index = bt.insert(books, index);
				break;
			case 3:
				bt.update(books, index);
				break;
			case 4:
				index = bt.delete(books, index);
				break;
			case 5:
				bt.find(books, index);
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("�߸� �����̽��ϴ�. �ٽ� �Է����ֽʽÿ�");
				break;
			}
			s.close();
		}
	}
	
	public int list(Book[] books, int index) {
		int temp=0;
		for (int i = 0; i < index; i++) {
			temp=i+1;
			System.out.println("--------------------------------");
			System.out.println(temp+": " + books[i].toString());
		}
		return 0;
	}
	public int insert(Book[] books, int index) {
		Scanner s = new Scanner(System.in);
		System.out.println("1: Book, 2: Magazine");
		int input = s.nextInt();
		
		System.out.println("Isbn�� �Է��ϼ���.");
		String isbn = s.next();
		System.out.println("Title�� �Է��ϼ���.");
		String title = s.next();
		System.out.println("Author�� �Է��ϼ���.");
		String author = s.next();
		System.out.println("Publicher�� �Է��ϼ���.");
		String publisher = s.next();
		System.out.println("Price�� �Է��ϼ���.");
		int price = s.nextInt();
		System.out.println("desc�� �Է��ϼ���.");
		String desc = s.next();
		int year=0, month=0;
		Book b = null;
		if(input==2) {
			System.out.println("������ �Է��ϼ���.");
			year = s.nextInt();
			System.out.println("���� �Է��ϼ���.");
			month = s.nextInt();
			b = new Magazine(isbn, title, author, publisher, price, year, month);
		} else {	
			b = new Book(isbn, title, author, publisher, price, desc);
		}
		books[index]=b;
		index++;
		s.close();
		return index;
	}
	public int update(Book[] books, int index) {
		Scanner s = new Scanner(System.in);
		System.out.println("������ Isbn�� �Է��ϼ���.");
		String isbn = s.next();
		System.out.println("������ Title�� �Է��ϼ���.");
		String title = s.next();
		System.out.println("������ Author�� �Է��ϼ���.");
		String author = s.next();
		System.out.println("������ Publicher�� �Է��ϼ���.");
		String publisher = s.next();
		System.out.println("������ Price�� �Է��ϼ���.");
		int price = s.nextInt();
		System.out.println("������ desc�� �Է��ϼ���.");
		String desc = s.next();
		
		int input = 0;
		Book b = null;
		System.out.println("1: Book, 2: Magazine");
		input=s.nextInt();
		if(input==2) {
			System.out.println("������ year�� �Է��ϼ���.");
			int year = s.nextInt();
			System.out.println("������ month�� �Է��ϼ���.");
			int month = s.nextInt();
			b = new Magazine(isbn, title, author, publisher, price, year, month);
		}
		else {
			b = new Book(isbn, title, author, publisher, price, desc);
		}
		for(int i=0; i<index; i++) {
			if(books[i].getIsbn().equals(isbn)) {
					books[i]=b;
			}
		}
		s.close();
		return 0;
	}
	
	public int delete(Book[] books, int index) {
		Scanner s = new Scanner(System.in);
		System.out.println("������ Isbn�� �Է��ϼ���.");
		String isbn = s.next();
		
		for(int i=0; i<index; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				books[i] = books[index-1];
				index--;
			}
		}	
		s.close();
		return index;
	}
	
	public int find(Book[] books, int index) {
		Scanner s = new Scanner(System.in);
		System.out.println("ã�� Isbn�� �Է��ϼ���.");
		String isbn = s.next();
		
		for(int i=0; i<index; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				System.out.println( books[i].toString());
			}
		}	
		s.close();
		return 0;
	}
}