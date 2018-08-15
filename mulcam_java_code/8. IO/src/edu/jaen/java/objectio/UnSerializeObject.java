package edu.jaen.java.objectio;
import java.io.*;
public class UnSerializeObject{
   public static void main (String args[]) {
		Customer d = null;
		try {
			FileInputStream f = new FileInputStream ("Data.ser");
			ObjectInputStream s = new ObjectInputStream (f);
			d = (Customer) s.readObject ();
			s.close ();
		} catch (Exception e) {
			 e.printStackTrace ();
		}
		System.out.println("Unserialized Customer object from Data.txt");
	    System.out.println("Customer: "+d);
  }
}
