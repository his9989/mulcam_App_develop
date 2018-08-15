package edu.jaen.java.usingio;
import java.io.*;
class DataOutputTest {
   public static void main(String arg[]) {
      try {
//         FileOutputStream fos = 
//				new FileOutputStream("TestFile.txt");
//         BufferedOutputStream bos = 
//				new BufferedOutputStream(fos);
//         DataOutputStream dos = 
//				new DataOutputStream(bos);
         
         DataOutputStream dos = 
        		 new DataOutputStream(
        				 new BufferedOutputStream(
        						 new FileOutputStream("TestFile.txt")));
         
		 dos.writeInt(4);
         dos.writeDouble(3.0);
		 dos.writeBoolean(true);
		 dos.writeUTF("this is");
         dos.close();
		System.out.println("정상적으로 저장되었습니다");
	  }catch(IOException e) {
         System.out.println("ERROR "+ e.toString()); 
      } 
   }
}