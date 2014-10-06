package com.hans.saveObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveObject {
	public static void main(String[] args) throws Exception {
		ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
				"C:/code/eclipse/io/src/a.txt"));
		oo.writeObject(new Car());
		ObjectInputStream oi = new ObjectInputStream(new FileInputStream(
				"C:/code/eclipse/io/src/a.txt"));
		System.out.println(oi.readObject());
	}
}
