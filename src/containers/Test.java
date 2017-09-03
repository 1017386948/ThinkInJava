package containers;

import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

public class Test {
	Integer in;
	Iterator i;
	Collection c;
	Map m;
	HashMap hm;
	TreeMap tm;
	Queue q;
	LinkedList ll;
	Collections cs;
	AbstractMap am;
	ArrayList all;
	AbstractList al;
	Vector v;
	Collections cs1;

	public static void main(String[] args) {
		List<Integer> li = new LinkedList<>(Arrays.asList(1, 2));
		// final int[] ii = new int[] {1,2,3};
		// ii[2] = 100;
		// System.out.println(Arrays.toString(ii));

		ListIterator<Integer> ii = li.listIterator();
		System.out.println(ii.next());
		ii.add(19);
		System.out.println(li);
		System.out.println(li.hashCode() & 127);
	}

	class CountingTntegerList extends AbstractList<Integer> {
		private int size;

		public CountingTntegerList(int size) {
			this.size = size < 0 ? 0 : size;
		}

		@Override
		public Integer get(int index) {
			return Integer.valueOf(index);
		}

		@Override
		public int size() {
			return size;
		}

	}

	private static class FlyweightMap extends AbstractMap<String, String> {

		private static class Entry implements Map.Entry<String, String> {

			@Override
			public String getKey() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getValue() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String setValue(String value) {
				// TODO Auto-generated method stub
				return null;
			}

		}

		@Override
		public Set<java.util.Map.Entry<String, String>> entrySet() {

			return null;
		}

	}
}

class SlowMap2<K, V> extends AbstractMap<K, V> {
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();

	@Override
	public V put(K key, V value) {
		if (key == null)
			throw new NullPointerException();
		V oldValue = get(key); // The old value or null
		if (!keys.contains(key)) {
			keys.add(key);
			values.add(value);
		} else
			values.set(keys.indexOf(key), value);
		return oldValue;
	}

	@Override
	public V get(Object key) {
		if (key == null)
			throw new NullPointerException();
		if (!keys.contains(key))
			return null;
		return values.get(keys.indexOf(key));
	}

	private EntrySet entrySet = new EntrySet();

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		return entrySet;
	}

	// Uses the 'Flyweight' pattern
	private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
		@Override
		public Iterator<Map.Entry<K, V>> iterator() {
			return new Iterator<Map.Entry<K, V>>() {
				private int index = -1;
				boolean canRemove;

				public boolean hasNext() {
					return index < keys.size() - 1;
				}

				public Map.Entry<K, V> next() {
					canRemove = true;
					++index;
					return new MapEntry<K, V>(keys.get(index), values.get(index));
				}

				public void remove() {
					if (!canRemove)
						throw new IllegalStateException();
					canRemove = false;
					keys.remove(index);
					values.remove(index--);
				}
			};
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean contains(Object o) {
			if (o instanceof MapEntry) {
				MapEntry<K, V> e = (MapEntry<K, V>) o;
				K key = e.getKey();
				if (keys.contains(key))
					return e.equals(new MapEntry<K, V>(key, get(key)));
			}
			return false;
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean remove(Object o) {
			if (contains(o)) {
				MapEntry<K, V> e = (MapEntry<K, V>) o;
				K key = e.getKey();
				V val = e.getValue();
				keys.remove(key);
				values.remove(val);
				return true;
			}
			return false;
		}

		@Override
		public int size() {
			return keys.size();
		}

		@Override
		public void clear() {
			keys.clear();
			values.clear();
		}
	}
}
