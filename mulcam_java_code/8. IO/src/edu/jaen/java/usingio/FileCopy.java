package edu.jaen.java.usingio;
import java.io.*;
class FileCopy {
   public static void main(String arg[]) {
      try {
         if(arg.length != 2) {
            System.out.println("Usage: java FileCopy " + "sourceFile destFile");
            System.exit(1);
         }
         FileInputStream fis = new FileInputStream(arg[0]); //읽을 파일
         FileOutputStream fos = new FileOutputStream(arg[1]); //쓸 파일
         int ch;
         while((ch=fis.read()) != -1 )//파일내용의 끝을 리턴시키는 숫자. eof임
             fos.write((byte) ch);     //이진코드로 읽고, 쓰는 메소드                   
         fis.close();
         fos.close();              
      } catch(IOException e) {
         System.out.println("ERROR "+ e.toString()); 
      } 
   }
}