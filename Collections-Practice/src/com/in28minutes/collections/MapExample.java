package com.in28minutes.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {
public static void main(String[] args) {
	
	String str ="This is an awesome occasion. Hello World";
	
	HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	
	for(int i=0;i<str.length();i++) {
		map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
	}

	System.out.println("Character hashmap: "+map);
	
	
	String[] wordArray= str.split(" ");
	
	HashMap<String, Integer> wordMap = new HashMap<>();
	for(String s:wordArray) {
		
		if(wordMap.get(s)!=null) {
			
			wordMap.put(str, wordMap.get(s)+1);
		}else {
			wordMap.put(s, 1);
		}
		
		
	}
	
	System.out.println("Word hashmap: "+wordMap);

	
	
	
	
	
	
	
}
}
