package holding;

import java.util.*;

import net.mindview.util.Countries;

public class SetOrder {
	public static void main(String[] args) {
		Set<String> s1 = new HashSet<String>(Countries.names(25));
		System.out.println(s1);
		String[] keys = s1.toArray(new String[0]);
		Arrays.sort(keys);
		Set<String> s2 = new LinkedHashSet<String>(Arrays.asList(keys));
		System.out.println(s2);
	}
}
