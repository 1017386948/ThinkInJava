package containers;

import java.util.TreeSet;

import net.mindview.util.CollectionData;
import net.mindview.util.RandomGenerator;

public class RandTreeSet {
	public static void main(String[] args) {
		TreeSet<String> tree = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
		tree.addAll(CollectionData.list(new RandomGenerator.String(), 10));
		System.out.println(tree);
	}
}
