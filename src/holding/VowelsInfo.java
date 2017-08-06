package holding;

import java.util.*;

import net.mindview.util.TextFile;

public class VowelsInfo {
	private final static Set<Character> vowels = new LinkedHashSet<Character>(Arrays.asList('A', 'E', 'I', 'O', 'U'));

	static void updateStat(Map<Character, Integer> stat, char letter) {
		Character ch = letter;
		Integer freq = stat.get(ch);
		stat.put(ch, freq == null ? 1 : freq + 1);
	}

	public static void main(String[] args) {
		Map<Character, Integer> stat = new LinkedHashMap<Character, Integer>();
		Set<String> words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		words.addAll(new TextFile("E:\\Java\\ThinkInJava\\src\\holding\\E04_MovieNameGenerator.java", "\\W+"));
		for (String word : words) {
			for (char c : word.toCharArray()) {
				char upc = Character.toUpperCase(c);
				if (vowels.contains(Character.valueOf(upc)))
					updateStat(stat, upc);
			}
		}
		System.out.println(stat);

	}
}
