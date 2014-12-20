package com.hans.test;

import com.google.common.base.CharMatcher;

public class Test {
	public static void main(String[] args) {
		String a = "hans@124.com";
	
		System.out.println(CharMatcher.anyOf("@12").matchesAnyOf(a));
		System.out.println(a.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$"));
	}
}
