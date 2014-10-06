package com.hans.copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferCopyStream {
	public static void main(String[] args) {
		try {
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream("C:/code/eclipse/io/src/a.txt"));
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream("C:/code/eclipse/io/src/b.txt"));

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
