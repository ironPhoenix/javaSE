package com.hans.test;

import com.hans.freeregex.FreeMatcher;



public class Test {
	public static void main(String[] args) {
/*		String a = "hans@124.com";
		long s1 = System.currentTimeMillis();
		for(int i=0;i<1000000;i++) {
		a.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
		}
		long e1 = System.currentTimeMillis();
		
		long s2 = System.currentTimeMillis();
		Pattern p = Pattern.compile("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
		Matcher m = p.matcher(a);
		for(int i=0;i<1000000;i++) {
			
		m.matches();
		}
		long e2 = System.currentTimeMillis();
		System.out.println(e1-s1);
		System.out.println(e2-s2);*/
		
		String a = "asdf safsd@ASDF.de.co";
				
		System.out.println(FreeMatcher.EMAIL.matchesAnyOf(a));
		System.out.println(FreeMatcher.EMAIL.retainFrom(a));
		System.out.println(FreeMatcher.EMAIL.retainFrom(a));

	}
}
