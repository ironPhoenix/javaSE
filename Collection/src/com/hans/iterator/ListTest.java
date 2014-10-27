package com.hans.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("a");
		l.add("b");
		Iterator<String> iterator = l.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
