package com.my.dispatch;

import java.util.Scanner;

import com.my.manager.ArrayManager;
import com.my.manager.IManager;
import com.my.manager.ListManager;
import com.my.vo.Book;
import com.my.vo.Magazine;
/** �������� ���α׷�
 * 
 * @author student
 * ��� : �Է�, ����, ����, ��ȸ, �˻�, ����
 * 
 * ���� -> �ݺ� (���(����) -> ���� -> ����) -> ���� 
 */
public class BookTest {
	static class aa{
		
	}
	static int a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//IManager man = new ListManager();
		ListManager man = new ListManager();
		
		Scanner s = new Scanner(System.in);
		int input=0;
		boolean flag = true;
		while(flag) {
			System.out.println("1.��ȸ,2.�Է�,3.����,4.����,5.�˻�,6.����");
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
				System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���");
				break;
			}
		}
	}
	
	

}
