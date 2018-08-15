package edu.jaen.java.modifier;
 class Var { 
        final double PI=3.141592; //상수. primitive 상수명은 모두 대문자
		int su=10;
} 
class FinalVarTest{ 
	public static void main(String s[]){
         Var f1 = new Var(); 
		 //	f1.PI=20;   //final 변수여서 값변경 안됨
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
