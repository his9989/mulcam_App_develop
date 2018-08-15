package edu.jaen.java.usingio;
import java.io.*;

class InputKeyboard {
   public static void main (String arg[]) {
	   InputStream is=System.in;
	   PrintStream o=System.out;
	   try{
		   int ch=is.read();
		   o.println((char)ch);
	   } catch (IOException e) {
         System.out.println(e.getMessage());
      }

	   /*
      String line;
      InputStreamReader ir;
      BufferedReader bir;
      try {
         ir = new InputStreamReader(System.in); //
         bir= new BufferedReader(ir);

         do {
            line = bir.readLine();
            System.out.println(line);
         } while (line != null);

         bir.close();
         ir.close();

      } catch (IOException e) {
         System.out.println(e.getMessage());
      }*/
   }
} 