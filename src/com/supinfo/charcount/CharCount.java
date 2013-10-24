package com.supinfo.charcount;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CharCount {
	
	private static final String URI = "/home/kir/Documents/Workspace/CharCount/exemple.txt";
	
	private static Map<Character, Integer> result = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initMap();
		
		File file = new File(URI);
		char[] buffer = new char[(int) file.length()];
		FileInputStream fis = null;
		InputStreamReader isr = null;
		try {
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			isr.read(buffer);
			countChar(buffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void countChar(char[] buffer) {
		for(char c : buffer) {
			if(result.containsKey(c)) {
				result.put(c, result.get(c) + 1);
			}
		}
		for(Entry<Character, Integer> entry : result.entrySet()) {
			System.out.println(entry.getKey()+" - "+entry.getValue());
		}
	}
	
	private static void initMap() {
		if(result == null) {
			result = new HashMap<Character, Integer>();
		}
		char[] tab = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
				'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		for(char c : tab) {
			result.put(c, 0);
		}
	}

}
