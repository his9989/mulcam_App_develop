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
		
		System.out.println("Isbn을 입력하세요.");
		String isbn = s.next();
		System.out.println("Title을 입력하세요.");
		String title = s.next();
		System.out.println("Author을 입력하세요.");
		String author = s.next();
		System.out.println("Publicher을 입력하세요.");
		String publisher = s.next();
		System.out.println("Price을 입력하세요.");
		int price = s.nextInt();
		System.out.println("desc을 입력하세요.");
		String desc = s.next();
		int year=0, month=0;
		Book b = null;
		if(input==2) {
			System.out.println("연도를 입력하세요.");
			year = s.nextInt();
			System.out.println("월을 입력하세요.");
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
		System.out.println("수정할 Isbn을 입력하세요.");
		String isbn = s.next();
		System.out.println("수정할 Title을 입력하세요.");
		String title = s.next();
		System.out.println("수정할 Author을 입력하세요.");
		String author = s.next();
		System.out.println("수정할 Publicher을 입력하세요.");
		String publisher = s.next();
		System.out.println("수정할 Price을 입력하세요.");
		int price = s.nextInt();
		System.out.println("수정할 desc을 입력하세요.");
		String desc = s.next();
		
		int input = 0;
		Book b = null;
		System.out.println("1: Book, 2: Magazine");
		input=s.nextInt();
		if(input==2) {
			System.out.println("수정할 year을 입력하세요.");
			int year = s.nextInt();
			System.out.println("수정할 month을 입력하세요.");
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
		System.out.println("삭제할 Isbn을 입력하세요.");
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
		System.out.println("찾을 Isbn을 입력하세요.");
		String isbn = s.next();
		
		for(int i=0; i<index; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				System.out.println( books[i].toString());
			}
		}	
		return 0;
	}
	
}
