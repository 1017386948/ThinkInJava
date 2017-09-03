package containers;

import java.util.LinkedHashSet;
import java.util.Set;
import static net.mindview.util.Countries.*;

public class VerifySet {
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<String>();
		for (int i = 0; i < 5; i++)
			set.addAll(names(5));
		System.out.println(set);
	}
}