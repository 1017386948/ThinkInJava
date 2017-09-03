package containers;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CountingMapData extends AbstractMap<Integer, String> {

	private int size;
	private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

	public CountingMapData(int size) {
		this.size = size < 0 ? 0 : size;
	}

	class Entry implements Map.Entry<Integer, String> {
		int index;

		Entry(int index) {
			this.index = index;
		}

		@Override
		public Integer getKey() {
			return index;
		}

		@Override
		public String getValue() {
			return chars[index % chars.length] + Integer.toString(index / chars.length);
		}

		@Override
		public String setValue(String value) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof Entry && index == ((Entry) obj).index;
		}

		@Override
		public int hashCode() {
			return Integer.valueOf(index).hashCode();
		}
	}

	class EntrySet extends AbstractSet<Map.Entry<Integer, String>> {

		private class Iter implements Iterator<Map.Entry<Integer, String>> {
			private Entry entry = new Entry(-1);

			@Override
			public boolean hasNext() {
				return entry.index < size - 1;
			}

			@Override
			public Map.Entry<Integer, String> next() {
				entry.index++;
				return entry;
			}

		}

		@Override
		public Iterator<Map.Entry<Integer, String>> iterator() {
			return new Iter();
		}

		@Override
		public int size() {
			return size;
		}

	}

	private Set<Map.Entry<Integer, String>> entries = new EntrySet();

	@Override
	public Set<Map.Entry<Integer, String>> entrySet() {
		return entries;
	}

	public static void main(String[] args) {
		System.out.println(new CountingMapData(60));
	}

}
