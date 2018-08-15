package edu.jaen.java.io;
import java.io.*;
class FileRead {
   public static void main(String arg[]) throws Exception{
	     File f=new File("Data.txt");
	     FileReader fr = new FileReader(f);
	     
	     BufferedReader br = 
	    		 new BufferedReader(							// buffer�� �־ �ӵ��� ������
	    				 new InputStreamReader(					// byte�� Character�� ��ȯ
	    						 new FileInputStream(f)));		// byte Source �ڵ�
	     
	     File fw = new File("write.txt");
	     
	     BufferedWriter bw = 
	    		 new BufferedWriter(							// buffer�� �־ �ӵ� ������
	    				 new OutputStreamWriter(				// byte�� Character�� ��ȯ
	    						 new FileOutputStream(fw)));	// byte Sink �ڵ�
	     
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

//�ǽ� ����
//���α׷� ������ out ������ �����ϰ�, 
//Data.txt�� �о out�������� Data2.txt�� ����ϴ� ���α׷��� �ۼ��Ͽ� ������.