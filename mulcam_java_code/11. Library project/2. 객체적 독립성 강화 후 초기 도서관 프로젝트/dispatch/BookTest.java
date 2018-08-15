package com.my.dispatch;

import java.util.Scanner;

import com.my.manage.ArrayManage;

/** 도서관리 프로그램
 * @author student
 * 기능: 입력, 수정, 삭제, 조회, 검색, 종료
 * 시작 -> 반복 {기능(선택) -> 선택 -> 수행} -> 종료
 */

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayManage man = new ArrayManage();
		Scanner s = new Scanner(System.in);

		int input=0;
		boolean flag = true;
		
		while(flag) {
			System.out.println("================================");
			System.out.println("1.조회  2.입력  3.수정  4.삭제  5.검색  6.종료");
			System.out.println("================================");
			input = s.nextInt();
			
			switch (input) {
			case 1:
				man.list();
				break;
			case 2:
				man.insert();
				break;
			case 3:
				man.update();
				break;
			case 4:
				man.delete();
				break;
			case 5:
				man.find();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("잘못 누르셨습니다. 다시 입력해주십시오");
				break;
			}
		}
	}
	
	
}