package com.hans.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyStream {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("C:/code/eclipse/io/src/a.txt");
			FileOutputStream fos = new FileOutputStream("C:/code/eclipse/io/src/b.txt",true);
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
