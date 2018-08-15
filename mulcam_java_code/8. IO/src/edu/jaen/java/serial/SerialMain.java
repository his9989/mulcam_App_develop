package edu.jaen.java.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b = new Book("È«±æµ¿Àü", "ÀÚ¾Ø", 10000);
		
		try {
			FileOutputStream fos = new FileOutputStream("book.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(b);

			fos.close();
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
