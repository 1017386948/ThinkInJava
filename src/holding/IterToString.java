package holding;

import java.util.*;


public class IterToString {
	public static void main(String[] args) {
		List<Collection<String>> ca = Arrays.<Collection<String>>asList(
				new ArrayList<String>(),
				new LinkedList<String>(),
				new HashSet<String>(),
				new TreeSet<String>());
		for(Collection<String> c : ca)
			E04_MovieNameGenerator.fill(c);
		for(Collection<String> c : ca)
			printToStrings(c.iterator());
	}
	
	public static void printToStrings(Iterator<?> it) {
		System.out.println(it.next());
	}
}
