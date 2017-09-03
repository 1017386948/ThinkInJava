package containers;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import net.mindview.util.Countries;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
	static final int size = 1 << 7;
	@SuppressWarnings("unchecked")
	private LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[size];
	static final float DEFAULT_LOAD_FACTOR = 0.75f;
	GetIndex getIndex = new GetIndex();

	@Override
	public V put(K key, V value) {
		V oldValue = null;
		// int index = getIndex.getIndex1(key.hashCode());
		// int index = getIndex.getIndex2(key.hashCode());
		int index = getIndex.getIndex3(key.hashCode());
		MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
		if (buckets[index] == null)
			buckets[index] = new LinkedList<MapEntry<K, V>>();
		//  µœ÷¥Ú”°≥ÂÕª
		// else {
		// System.out.println("Collision while adding\n" + pair + "\nBucket already
		// contains:");
		// Iterator<MapEntry<K, V>> it = buckets[index].iterator();
		// while (it.hasNext())
		// System.out.println(it.next());
		// }
		LinkedList<MapEntry<K, V>> bucket = buckets[index];
		boolean found = false;
		ListIterator<MapEntry<K, V>> it = bucket.listIterator();
		while (it.hasNext()) {
			Map.Entry<K, V> iPair = it.next();
			if (iPair.getKey().equals(key)) {
				oldValue = iPair.getValue();
				it.set(pair);
				found = true;
				break;
			}
		}
		if (!found) {
			buckets[index].add(pair);
		}
		return oldValue;
	}

	class GetIndex {
		int getIndex1(int hash) {
			return Math.abs(hash) % size;
		}

		int getIndex2(int hash) {
			return hash & 127;
		}

		int getIndex3(int hash) {
			int index = hash;
			return ((index = hash) ^ (index >>> 16)) & 127;
		}
	}

	@Override
	public V get(Object key) {
		// int index = Math.abs(key.hashCode()) % size;
		// int index = getIndex.getIndex2(key.hashCode());
		int index = getIndex.getIndex3(key.hashCode());
		if (buckets[index] == null)
			return null;
		for (MapEntry<K, V> iPair : buckets[index]) {
			if (iPair.getKey().equals(key)) {
				return iPair.getValue();
			}
		}
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> set = new HashSet<>();
		for (LinkedList<MapEntry<K, V>> bucket : buckets) {
			if (bucket == null)
				continue;
			for (MapEntry<K, V> mpair : bucket)
				set.add(mpair);
		}
		return set;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		buckets = new LinkedList[size];
	}

	@Override
	public V remove(Object key) {
		int index = getIndex.getIndex3(key.hashCode());
		if (buckets[index] == null)
			return null;
		Iterator<MapEntry<K, V>> it = buckets[index].iterator();
		while (it.hasNext()) {
			MapEntry<K, V> iPair = it.next();
			if (iPair.getKey().equals(key)) {
				V value = iPair.getValue();
				it.remove();
				return value;
			}
		}
		return null;
	}

	@Override
	public boolean containsKey(Object key) {
		for (LinkedList<MapEntry<K, V>> bucket : buckets) {
			if (bucket == null)
				continue;
			for (MapEntry<K, V> mPair : bucket) {
				if (mPair.getKey().equals(key))
					return true;
			}
		}
		return false;

	}

	@Override
	public boolean containsValue(Object value) {
		for (LinkedList<MapEntry<K, V>> bucket : buckets) {
			if (bucket == null)
				continue;
			for (MapEntry<K, V> mPair : bucket) {
				if (mPair.getValue().equals(value))
					return true;
			}
		}
		return false;
	}

	public boolean isEmpty() {
		// Could just say return size() == 0;
		// but this is faster:
		for (LinkedList<MapEntry<K, V>> bucket : buckets)
			if (bucket != null)
				return false;
		return true;
	}

	@Override
	public int size() {
		// Could rely on the inherited implementation, which
		// returns entrySet().size(), but this is faster:
		int sz = 0;
		for (LinkedList<MapEntry<K, V>> bucket : buckets)
			if (bucket != null)
				sz += bucket.size();
		return sz;
	}

	public static void main(String[] args) {
		SimpleHashMap<String, String> m = new SimpleHashMap<>();
		Map<String, String> country = Countries.capitals(75);
		Set<String> s = country.keySet();
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			m.clear();
			m.putAll(country);
			for (String name : s) {
				m.get(name);
			}
		}
		System.out.println(System.currentTimeMillis() - t1);
		HashMap<String, String> m2 = new HashMap<>();
		long t2 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			m2.clear();
			m2.putAll(country);
			for (String name : s) {
				m2.get(name);
			}
		}
		System.out.println(System.currentTimeMillis() - t2);
		// m.clear();
		System.out.println(m.containsKey("CAPE VERDE"));
		System.out.println(m.remove("CAPE VERDE"));
		System.out.println(m.containsKey("CAPE VERDE"));
		System.out.println(m);
	}

}
