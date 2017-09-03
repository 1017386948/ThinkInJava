package containers;

import java.util.List;
import java.util.Properties;

import net.mindview.util.TextFile;

class AssociativeArray<K, V> {
	private Object[][] pairs;
	private int index;

	public AssociativeArray(int length) {
		pairs = new Object[length][2];
	}

	public void put(K k, V v) {
		for (int i = 0; i < index; i++)
			if (k.equals(pairs[i][0])) {
				pairs[i] = new Object[] { k, v };
				return;
			}
		if (index >= pairs.length)
			throw new ArrayIndexOutOfBoundsException();
		pairs[index++] = new Object[] { k, v };
	}

	@SuppressWarnings("unchecked")
	public V get(K k) {
		for (int i = 0; i < pairs.length; i++) {
			if (k.equals(pairs[i][0])) {
				return (V) pairs[i][1];
			}
		}
		return null;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < index; i++) {
			result.append(pairs[i][0].toString());
			result.append(" : ");
			result.append(pairs[i][1].toString());
			if (i < index - 1)
				result.append("\n");
		}
		return result.toString();
	}
}

public class WordCounter {
	public static void main(String[] args) {
		List<String> words = new TextFile("E:\\Java\\ThinkInJava\\src\\containers\\WordCounter.java", "\\W+");
		AssociativeArray<String, Integer> map = new AssociativeArray<>(words.size());
		for (String word : words) {
			Integer freq = map.get(word);
			freq = freq == null ? 1 : freq + 1;
			map.put(word, freq);
		}
		System.out.println(map);
		Properties p;
	}
}
