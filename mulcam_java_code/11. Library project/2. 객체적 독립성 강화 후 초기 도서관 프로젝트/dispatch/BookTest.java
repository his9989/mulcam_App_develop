package com.my.dispatch;

import java.util.Scanner;

import com.my.manage.ArrayManage;

/** �������� ���α׷�
 * @author student
 * ���: �Է�, ����, ����, ��ȸ, �˻�, ����
 * ���� -> �ݺ� {���(����) -> ���� -> ����} -> ����
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
			System.out.println("1.��ȸ  2.�Է�  3.����  4.����  5.�˻�  6.����");
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
				System.out.println("�߸� �����̽��ϴ�. �ٽ� �Է����ֽʽÿ�");
				break;
			}
		}
	}
	
	
}