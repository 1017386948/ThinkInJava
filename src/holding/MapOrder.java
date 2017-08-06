package holding;

import java.util.*;
import net.mindview.util.*;

public class MapOrder {
	public static void main(String[] args) {
		Map<String, String> m1 = new HashMap<String, String>(Countries.capitals(25));
		System.out.println(m1);
//		Iterator<Map.Entry<String, String>>  = m1.entrySet().iterator();
		String[] keys = m1.keySet().toArray(new String[0]);
		Arrays.sort(keys);
		Map<String, String> m2 = new LinkedHashMap<String, String>();
		for(String s: keys) {
			m2.put(s, m1.get(s));
		}
		System.out.println(m2);
	}
}
