package edu.jaen.java.modifier;
 class Var { 
        final double PI=3.141592; //���. primitive ������� ��� �빮��
		int su=10;
} 
class FinalVarTest{ 
	public static void main(String s[]){
         Var f1 = new Var(); 
		 //	f1.PI=20;   //final �������� ������ �ȵ�
			f1.su=20;

		 System.out.println(Constants.COUNT);
		 System.out.println(Constants.END);

      }  
}    	
class Constants {
	public static final double PI=3.141592;
	public static final int COUNT=50;
	public static final int START=10;
	public static final int END=100;	
}
