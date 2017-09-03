package containers;

public class StringContainer {
	private String[] array;
	private int index;
	private static final int INCR = 255;

	public StringContainer() {
		array = new String[10];
	}

	public void add(String s) {
		if (index >= array.length) {
			String[] tmp = new String[array.length + INCR];
			for (int i = 0; i < array.length; i++)
				tmp[i] = array[i];
			index = array.length;
			array = tmp;
		}
		array[index++] = s;
	}

	public String get(int i) {
		return array[i];
	}

	public int size() {
		return index;
	}
}
