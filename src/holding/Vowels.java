package holding;

import java.util.*;


import net.mindview.util.TextFile;

public class Vowels {
	final static int i12 =1;
	public static void main(String[] args) {
		Set<String> vowel = new HashSet<String>();
		Collections.addAll(vowel, "a e i o u A E I O U".split(" "));
		Set<String> words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		words.addAll(new TextFile("E:\\Java\\ThinkInJava\\src\\holding\\E04_MovieNameGenerator.java", "\\W+"));
		int i = 0;
		for (String s : words) {
			int j = 0;
			for (char c : s.toCharArray())
				j = vowel.contains(String.valueOf(c)) ? j + 1 : j;
			i = j > 0 ? i + 1 : i;
			System.out.println(s + ": " + j);
		}
		System.out.println("vowel words: " + i);
//		Integer inte;
//		String s ;
//		Map<Object,Object> m = new HashMap<>();

	}
}
