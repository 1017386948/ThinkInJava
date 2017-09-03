package containers;

import java.util.List;
import net.mindview.util.*;

public class WordCounter3 {
	public static void main(String[] args) {
		List<String> words = new TextFile("E:\\Java\\ThinkInJava\\src\\containers\\WordCounter.java", "\\W+");
		SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
		for (String word : words) {
			Integer freq = map.get(word);
			map.put(word, freq == null ? 1 : freq + 1);
		}
		System.out.println(map);
	}
}
