package com.hans.freeregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class FreeMatcher {

	public static final FreeMatcher EMAIL = new FreeMatcher() {
		@Override
		public Matcher getMatcher(CharSequence sequence) {
			Pattern pattern = Pattern
					.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
			return pattern.matcher(sequence);		
		}
	};
	
	public static FreeMatcher anyOf(String regex) {
		return new FreeMatcher() {
			@Override
			public Matcher getMatcher(CharSequence sequence) {
				Pattern pattern = Pattern
						.compile(regex);
				return pattern.matcher(sequence);		
			}
		};
		
	}
	
	abstract Matcher getMatcher(CharSequence sequence);

	public boolean matchesAllOf(CharSequence sequence) {
		return getMatcher(sequence).matches();
	}
	public boolean matchesAnyOf(CharSequence sequence) {
		Matcher m = getMatcher(sequence);
		m.reset();
		return m.find();
	}

	public String retainFrom(CharSequence sequence) {
		Matcher m = getMatcher(sequence);
		if(m.find()) {
			return  m.group();
		}
		return null;	
	}
}
