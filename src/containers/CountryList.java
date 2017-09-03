package containers;

import static net.mindview.util.Countries.names;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CountryList {
	public static void main(String[] args) {
		List<String> l1 = new LinkedList<String>(names(8));
		List<String> l2 = new ArrayList<String>(names(8));
		System.out.println(l1);
		Collections.shuffle(l1);
		Collections.shuffle(l2);
		System.out.println(l1);
		System.out.println(l2);
		
	}
}
