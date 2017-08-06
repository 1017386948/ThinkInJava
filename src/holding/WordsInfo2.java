package holding;

import java.util.Comparator;

import net.mindview.util.TextFile;

import java.util.*;

class WordCounter{
	public static final Comparator<WordCounter> CASE_INSENSITIVE_ORDER = new Comparator<WordCounter>(){
		public int compare(WordCounter o1,WordCounter o2) {
			return o1.word.compareTo(o2.word);
		}
	};
	
	private final String word;
	private int frequency;
	WordCounter(String word) {
		this.word = word;
		frequency = 1;
	}
	public String getWord() {
		return this.word;
	}
	void incFrequency() { ++frequency; }
	int getFrequency() { return frequency; }
	@Override
	public boolean equals(Object o) {
		return o instanceof WordCounter &&
				word.equals(((WordCounter)o).word);
	}
	public int hashCode() { return word.hashCode(); }
	
}

public class WordsInfo2 {
	static void updateStat(Iterator<WordCounter> it,WordCounter wc) {
		while(it.hasNext()) {
			WordCounter currentWC = it.next();
			if(currentWC.equals(wc)) {
				currentWC.incFrequency();
			}
		}
	}
	
	public static void main(String[] args) {
		Set<WordCounter> stat = new HashSet<WordCounter>();
		for(String word: new TextFile("E:\\Java\\ThinkInJava\\src\\holding\\E04_MovieNameGenerator.java", "\\W+")) {
			WordCounter wc = new WordCounter(word);
			if(stat.contains(wc)) {
				updateStat(stat.iterator(), wc);
			}
			else stat.add(wc);
		}
		List<WordCounter> l = new ArrayList<WordCounter>(stat);
		Collections.sort(l, WordCounter.CASE_INSENSITIVE_ORDER);
//		for(WordCounter wc : l)
//			System.out.println(wc.getWord() + " => "+ wc.getFrequency());
		WordCounter w1 = new WordCounter("abc");
		WordCounter w2 = new WordCounter("abc");
		System.out.println(w1.equals(w2));
	}

}
