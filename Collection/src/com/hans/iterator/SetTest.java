package com.hans.iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		s.add("aa");
		s.add("bb");
		s.add("cc");
		Iterator<String> i = s.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
