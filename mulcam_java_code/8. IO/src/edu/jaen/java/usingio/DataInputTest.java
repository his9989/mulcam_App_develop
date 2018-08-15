package edu.jaen.java.usingio;
 import java.io.*;
class DataInputTest {
   public static void main(String arg[]) {
      try {
         FileInputStream fis = 
					new FileInputStream("TestFile.txt");
         BufferedInputStream bis = 
					new BufferedInputStream(fis);
         DataInputStream dis = 
					new DataInputStream(bis);
		 int i = dis.readInt();
         double d = dis.readDouble();
		 boolean b = dis.readBoolean();
		 String s = dis.readUTF();
		 System.out.println(d); 
         System.out.println(i);
		 System.out.println(b); 
		 System.out.println(s);
  		 dis.close();
  		 bis.close();
   		 fis.close();
      } catch(IOException e) {
         System.out.println("ERROR "+ e.toString()); 
	  } 
	}
}