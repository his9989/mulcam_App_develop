package edu.jaen.java;							//���� package�� customer.java�� ����� �� �ִ�. (?)
class CustomerTest								//���α׷� ���� �뵵�� class. java�� ��ü �����̹Ƿ�, ���� class�� ��üȭ ����. class �ۿ����� � �ڵ嵵 �ۼ� �Ұ�
{
	public static void main(String[] args) 
	{
		Customer cu=new Customer();				//customer�̶�� class�� Ʋ�� �ؼ� cu��� ��ü�� ����.
		cu.name="ȫ�浿";							//cu��� ��ü�� name ������ "ȫ�浿"����
		cu.address="����";						
		cu.age=20;
		cu.customerInfo();						//��ü�� customerInfo method �����
		
		Customer cu2=new Customer();			//Customer�� class, cu2�� ��ü Customer class Ʋ�� ��������, cu2�� �����Ӱ� �ٲ� �� �ִ�.
		cu2.name = "�Ѹ�";
		cu2.age=7;
		cu2.address="�ֹ���";
		cu2.customerInfo();
	}
}