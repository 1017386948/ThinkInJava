package containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;

public class Test2 {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<>();
		ListIterator<String> it = ((ArrayList<String>) c).listIterator();
		it.add("sss");
		it = ((ArrayList<String>) c).listIterator();
		try {
			System.out.println(it.next());
		} catch (ConcurrentModificationException e) {
			System.out.println(e);
		}
	}
}
