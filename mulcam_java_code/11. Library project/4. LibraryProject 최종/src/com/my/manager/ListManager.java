package com.my.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.my.vo.Book;
import com.my.vo.Magazine;

public class ListManager implements IManager{
//	private static final Exception DuplicatedIsbnException = null;
	private ArrayList<Book> list = new ArrayList();
	private int index = 0;
	//private Exception DuplicatedIsbnException;
	
	public void DuplicatesIsbnException(String Isbn) throws DuplicatedIsbnException{
		int i=0;
		for (i = 0; i < list.size(); i++) {
			if(list.get(i).getIsbn().equals(Isbn)) {
				System.out.println("Isbn이 중복되었습니다.");
				throw new DuplicatedIsbnException();
			}
		}
	}
	
	@Override
	public int insert() {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		System.out.println("1.book, 2.Magazine");
		int input = s.nextInt();
		
		System.out.println("isbn 입력하세요");
		String isbn = s.next();

		try {
			DuplicatesIsbnException(isbn);
		} catch (DuplicatedIsbnException e) {
			return index;
		}
		
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
		list.add(b);
		index++;
		return index;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		
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
		for (i = 0; i < list.size(); i++) {
			if(list.get(i).getIsbn().equals(isbn)) {
				list.remove(i);
				list.add(b);
			}
		}
		return i;
		}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("삭제할 isbn 을 입력하세요");
		String isbn = s.next();
		int i=0;
		for (i = 0; i < list.size(); i++) {
			if(list.get(i).getIsbn().equals(isbn)) {
				list.remove(i);
			}
		}
		return index;
	}

	@Override
	public int list() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		return 0;
		}

	@Override
	public int find() {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("검색할 isbn 을 입력하세요");
		String isbn = s.next();
		int i = 0;
		for (i = 0; i < list.size(); i++) {
			if(list.get(i).getIsbn().equals(isbn)) {
				System.out.println(list.get(i).toString());
			}
		}
		return 0;
		}

}
