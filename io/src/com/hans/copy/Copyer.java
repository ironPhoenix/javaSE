package com.hans.copy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copyer {
	public static void main(String[] args) {
		try {
			FileReader fis = new FileReader("C:/code/eclipse/io/src/a.txt");
			FileWriter fos = new FileWriter("C:/code/eclipse/io/src/b.txt",true);
			int i = 0;
			while ((i = fis.read()) != -1) {
				System.out.println((char)i);
				fos.write(i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
