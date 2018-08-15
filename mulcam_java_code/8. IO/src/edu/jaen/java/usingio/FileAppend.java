package edu.jaen.java.usingio;
import java.io.*;
class FileAppend {
   public static void main(String arg[]) {
      try {                              
         RandomAccessFile ra = 
				new RandomAccessFile("ran", "rw");
		
		 ra.seek(ra.length());
		 ra.writeBytes("Hello World!!!\n");     
         ra.writeChars("Hello\n");
		 ra.seek(0);
		 String str=ra.readLine();
		 System.out.println(str);                
         ra.close();
      } catch(IOException e) {e.printStackTrace();} 
   }
}