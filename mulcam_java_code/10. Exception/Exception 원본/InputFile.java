package edu.jaen.java.excep;

import java.io.*;

class InputFile {
	FileReader fis;

	InputFile(String filename) {
		fis = new FileReader("data.txt");
	}

	void readLine() {
		String s;
		BufferedReader buf = new BufferedReader(fis);
		while ((s = buf.readLine()) != null)
			System.out.println(s);

	}

	public static void main(String[] a) {
		InputFile inputFile = new InputFile("data.txt");
		inputFile.readLine();

		System.out.println("Program End...");
	}
}
