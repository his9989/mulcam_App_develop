package edu.jaen.java.usingio;
import java.io.*;
class FileCopy {
   public static void main(String arg[]) {
      try {
         if(arg.length != 2) {
            System.out.println("Usage: java FileCopy " + "sourceFile destFile");
            System.exit(1);
         }
         FileInputStream fis = new FileInputStream(arg[0]); //���� ����
         FileOutputStream fos = new FileOutputStream(arg[1]); //�� ����
         int ch;
         while((ch=fis.read()) != -1 )//���ϳ����� ���� ���Ͻ�Ű�� ����. eof��
             fos.write((byte) ch);     //�����ڵ�� �а�, ���� �޼ҵ�                   
         fis.close();
         fos.close();              
      } catch(IOException e) {
         System.out.println("ERROR "+ e.toString()); 
      } 
   }
}