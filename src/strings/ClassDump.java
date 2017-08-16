package strings;

import java.util.*;
import static java.lang.String.*;

class DataHolder {
	int intField = 1;
	long longField = 2L;
	float floatField = 3.0f;
	double doubleField = 4.0;

	public String toString() {
		StringBuilder result = new StringBuilder("DataHolder: \n");
		result.append(String.format(Locale.US, "intField: %d\n", intField));
		result.append(format(Locale.US, "longField: %d\n", longField));
		result.append(format(Locale.US, "floatField: %f\n", floatField));
		result.append(format(Locale.US, "doubleField: %f\n", doubleField));
		return result.toString();
	}
}

public class ClassDump {
	public static void main(String[] args) {
		DataHolder dataHolder = new DataHolder();
		System.out.println(dataHolder);
		StringTokenizer sw;
	}
}
