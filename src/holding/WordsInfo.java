package holding;

import java.util.*;

import net.mindview.util.TextFile;

public class WordsInfo {
	
	public static void main(String[] args) {
		Map<String, Integer> wordsStat = new HashMap<String, Integer>();
		for (String word : new TextFile("E:\\Java\\ThinkInJava\\src\\holding\\E04_MovieNameGenerator.java", "\\W+")) {
			Integer freq = wordsStat.get(word);
			wordsStat.put(word, freq == null ? 1 : freq + 1);
		}
		System.out.println(wordsStat);
		List<String> keys = new LinkedList<String>(wordsStat.keySet());
		Collections.sort(keys,String.CASE_INSENSITIVE_ORDER);
		for(String key:keys) {
			System.out.println(key + " => " + wordsStat.get(key));
		}
	}
}
