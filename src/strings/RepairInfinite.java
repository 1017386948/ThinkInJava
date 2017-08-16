package strings;

import java.util.ArrayList;
import java.util.List;

public class RepairInfinite {
	public String toString() {
		return " E02_RepairInfinite address: " + super.toString() + "\n";
	}

	public static void main(String[] args) {
		List<RepairInfinite> v = new ArrayList<RepairInfinite>();
		for (int i = 0; i < 10; i++)
			v.add(new RepairInfinite());
		System.out.println(v);
	}
}
