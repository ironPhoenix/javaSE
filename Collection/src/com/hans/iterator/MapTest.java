package com.hans.iterator;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {
	public static void main(String[] args) {
		Map<String,Date> m = new HashMap<>();
		m.put("a", new Date());
		Iterator<Entry<String,Date>> i = m.entrySet().iterator();
		while(i.hasNext()) {
			Entry<String,Date> e = i.next();
			System.out.println(e.getKey()+"  "+e.getValue());
		}
		
	}
}
