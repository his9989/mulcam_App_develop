package edu.jaen.java.objectio;
import java.io.*;
public class SerializeObject{
  public static void main (String args[]){
	Customer  c = new Customer();
		c.name="ȫ�浿";
		c.address="����";
		c.age=20;

    try {
      FileOutputStream f = 	new FileOutputStream ("Data.ser");
      BufferedOutputStream bos = new BufferedOutputStream(f);
      ObjectOutputStream s = new ObjectOutputStream (bos);
      s.writeObject(c);
	  System.out.println(" ������ �����Ǿ����ϴ�");
      s.close ();
	  f.close();
    } catch (IOException e) {
      e.printStackTrace ();
    }
  }
}
