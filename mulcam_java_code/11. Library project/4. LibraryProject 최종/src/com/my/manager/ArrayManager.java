package com.my.manager;

import java.util.Scanner;

import com.my.vo.Book;
import com.my.vo.Magazine;

public class ArrayManager implements IManager {
	private Book[] books;
	private int index = 0;
	
	public ArrayManager() {
		books = new Book[10];
	}
	
	public int insert() {
		Scanner s = new Scanner(System.in);
		System.out.println("1.book, 2.Magazine");
		int input = s.nextInt();
		
		System.out.println("isbn 입력하세요");
		String isbn = s.next();
		System.out.println("title 입력하세요");
		String title = s.next();
		System.out.println("author 입력하세요");
		String author = s.next();
		System.out.println("publisher 입력하세요");
		String publisher = s.next();
		System.out.println("price 입력하세요");
		int price = s.nextInt();
		System.out.println("desc 입력하세요");
		String desc = s.next();
		int year =0, month=0;
		Book b = null;
		if(input == 2) {
			System.out.println("년도를 입력하세요");
			year = s.nextInt();
			System.out.println("월을 입력하세요");
			month = s.nextInt();
			b = new Magazine(isbn, title, author, publisher, price, desc, year, month);
		}else {
			b = new Book(isbn, title, author, publisher, price, desc);
		}	
		books[index] = b;
		index++;
		return index;
	}
	public int update() {
		Scanner s = new Scanner(System.in);
		System.out.println("수정할 isbn 을 입력하세요");
		String isbn = s.next();
		System.out.println("수정할 title 입력하세요");
		String title = s.next();
		System.out.println("수정할 author 입력하세요");
		String author = s.next();
		System.out.println("수정할 publisher 입력하세요");
		String publisher = s.next();
		System.out.println("수정할 price 입력하세요");
		int price = s.nextInt();
		System.out.println("수정할 desc 입력하세요");
		String desc = s.next();
		Book b = new Book(isbn, title, author, publisher, price, desc);
		int i = 0;
		for (i = 0; i < index; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				books[i] = b;
			}
		}
		return i;
	}
	public int delete() {
		Scanner s = new Scanner(System.in);
		System.out.println("삭제할 isbn 을 입력하세요");
		String isbn = s.next();
		for (int i = 0; i < index; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				books[i] = books[index-1];
				index--;
			}
		}
		return index;
	}
	public int list() {
		for (int i = 0; i < index; i++) {
			System.out.println(books[i].toString());
			
		}
		return 0;
	}
	public int find() {
		Scanner s = new Scanner(System.in);
		System.out.println("삭제할 isbn 을 입력하세요");
		String isbn = s.next();
		for (int i = 0; i < index; i++) {
			if(books[i].getIsbn()==isbn) {
				System.out.println(books[i].toString());
			}
		}
		return 0;
	}
}
