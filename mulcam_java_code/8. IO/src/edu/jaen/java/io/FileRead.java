package edu.jaen.java.io;
import java.io.*;
class FileRead {
   public static void main(String arg[]) throws Exception{
	     File f=new File("Data.txt");
	     FileReader fr = new FileReader(f);
	     
	     BufferedReader br = 
	    		 new BufferedReader(							// buffer에 넣어서 속도를 빠르게
	    				 new InputStreamReader(					// byte를 Character로 변환
	    						 new FileInputStream(f)));		// byte Source 코드
	     
	     File fw = new File("write.txt");
	     
	     BufferedWriter bw = 
	    		 new BufferedWriter(							// buffer에 넣어서 속도 빠르게
	    				 new OutputStreamWriter(				// byte를 Character로 변환
	    						 new FileOutputStream(fw)));	// byte Sink 코드
	     
         String ch;
         while((ch=br.readLine()) != null ) {
             System.out.println(ch);         
             bw.write(ch+"\n");
         }
         br.close();   
         bw.flush();
         bw.close();
   }
}

//실습 예제
//프로그램 내에서 out 폴더를 생성하고, 
//Data.txt를 읽어서 out폴더내에 Data2.txt를 출력하는 프로그램을 작성하여 보세요.