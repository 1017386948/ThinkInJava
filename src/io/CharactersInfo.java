package io;

import java.util.Map;
import java.util.TreeMap;

public class CharactersInfo {
	static String fileName = "E:\\Java\\Tomcat\\apache-tomcat-8.5.16\\RUNNING.txt";

	public static void main(String[] args) {
		TextFile tf = new TextFile(fileName);
		Map<Character, Integer> charsStat = new TreeMap<>();
		for (String s : tf) {
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				Integer freq = charsStat.get(c);
				charsStat.put(c, freq == null ? 1 : freq + 1);
			}
		}
		System.out.println(charsStat);
	}
}
