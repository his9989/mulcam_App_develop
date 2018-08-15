package com.my.dispatch;

import java.util.Scanner;

import com.my.vo.Book;

import com.my.vo.Magazine;

/** 도서관리 프로그램
 * @author student
 * 기능: 입력, 수정, 삭제, 조회, 검색, 종료
 * 시작 -> 반복 {기능(선택) -> 선택 -> 수행} -> 종료
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
			System.out.println("1.조회  2.입력  3.수정  4.삭제  5.검색  6.종료");
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
				System.out.println("잘못 누르셨습니다. 다시 입력해주십시오");
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
		s.close();
		return index;
	}
	public int update(Book[] books, int index) {
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
		System.out.println("삭제할 Isbn을 입력하세요.");
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
		System.out.println("찾을 Isbn을 입력하세요.");
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