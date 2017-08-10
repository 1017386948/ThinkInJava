package holding;

import java.util.*;

import net.mindview.util.TextFile;

public class WordsInfo3 {

	public static void main(String[] args) {
		Map<String, ArrayList<Integer>> stat = new LinkedHashMap<String, ArrayList<Integer>>();
		int wordCount = 0;
		for (String word : new TextFile("E:\\Java\\ThinkInJava\\src\\holding\\WordsInfo3.java", "\\W+")) {
			ArrayList<Integer> loc = stat.get(word);
			if (loc == null) {
				loc = new ArrayList<Integer>();
				stat.put(word, loc);
			}
			loc.add(++wordCount);
		}
		System.out.println(new TextFile("E:\\Java\\ThinkInJava\\src\\holding\\WordsInfo3.java", "\\W+"));
		System.out.println(stat);

		Map<Integer, String> words = new TreeMap<Integer, String>();

		for (Map.Entry<String, ArrayList<Integer>> entry : stat.entrySet()) {
			for (Integer pos : entry.getValue())
				words.put(pos, entry.getKey());
		}
		System.out.println(words.values());
	
	}
}
