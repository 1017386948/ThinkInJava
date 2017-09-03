package containers;

import static net.mindview.util.Countries.capitals;
import static net.mindview.util.Countries.names;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ACountries {
	public static void main(String[] args) {
		TreeMap<String, String> map = new TreeMap<>(capitals());
		TreeSet<String> set = new TreeSet<String>(names());
		String b = null;
		for (String s : map.keySet())
			if (s.startsWith("B")) {
				b = s;
				break;
			}
		Map<String, String> aMap = map.headMap(b);
		Set<String> aSet = set.headSet(b);
		System.out.println("aMap = " + aMap);
		System.out.println("aSet = " + aSet);

		String s1 = new String("AAA");
		String s2 = new String("AAA");
		System.out.println(s1 == s2);
		System.out.println(s1.hashCode() == s2.hashCode());
		System.out.println("aaa".hashCode());
		String ss = "subStringTest";
		String ss1 = ss.substring(0, 2);
		String ss2 = ss.substring(0, 2);
		System.out.println(ss1 == ss2);
	}
}
