package edu.jaen.java.excep;

import java.io.*;

class InputFile {
	FileReader fis;
	
	public InputFile(String filename) throws  FileNotFoundException {
			fis = new FileReader("data.txt");

	}
	
	void close() throws IOException {
		fis.close();
	}

	void readLine() throws IOException {
		String s;
		BufferedReader buf = new BufferedReader(fis);
		while ((s = buf.readLine()) != null)
			System.out.println(s);

	}

	public static void main(String[] a) {
		InputFile inputFile = null;
		try {
			inputFile = new InputFile("data.txt");
			inputFile.readLine();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			
		}
		finally{
			try {
				inputFile.close();
			} catch(IOException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Program End...");
			}
		}
	}
}
