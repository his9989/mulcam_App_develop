package com.my.manage;

import java.util.Scanner;

import com.my.vo.Book;
import com.my.vo.Magazine;

public class ArrayManage {
	private Book[] books;
	private int index = 0;

	public ArrayManage() {
		books=new Book[10];
	}
	
	public int list() {
		int temp=0;
		for (int i = 0; i < index; i++) {
			temp=i+1;
			System.out.println("--------------------------------");
			System.out.println(temp+": " + books[i].toString());
		}
		return 0;
	}
	public int insert() {
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
		return index;
	}
	public int update() {
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
		int i=0;
		for(i=0; i<index; i++) {
			if(books[i].getIsbn().equals(isbn)) {
					books[i]=b;
			}
		}
		return i;
	}
	
	public int delete() {
		Scanner s = new Scanner(System.in);
		System.out.println("������ Isbn�� �Է��ϼ���.");
		String isbn = s.next();
		
		for(int i=0; i<index; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				books[i] = books[index-1];
				index--;
			}
		}	
		return index;
	}
	
	public int find() {
		Scanner s = new Scanner(System.in);
		System.out.println("ã�� Isbn�� �Է��ϼ���.");
		String isbn = s.next();
		
		for(int i=0; i<index; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				System.out.println( books[i].toString());
			}
		}	
		return 0;
	}
	
}
