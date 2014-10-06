package com.hans.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TransCopyer {
	public static void main(String[] args) {
		try {
			BufferedReader bis = new BufferedReader(new InputStreamReader(
					new FileInputStream("C:/code/eclipse/io/src/a.txt")));
			
			BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("C:/code/eclipse/io/src/b.txt")));
	
			String i ;
			while ((i = bis.readLine()) != null) {
				System.out.print(i);
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
