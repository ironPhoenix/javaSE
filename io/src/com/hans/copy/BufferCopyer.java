package com.hans.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferCopyer {
	public static void main(String[] args) {
		try {
			BufferedReader bis = new BufferedReader(
					new FileReader("C:/code/eclipse/io/src/a.txt"));
			BufferedWriter bos = new BufferedWriter(
					new FileWriter("C:/code/eclipse/io/src/b.txt"));

			int i = 0;
			while ((i = bis.read()) != -1) {
				System.out.println((char) i);
				bos.write(i);
				bos.flush();
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
