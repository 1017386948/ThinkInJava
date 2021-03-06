package containers;

import java.util.Map;

public class MapEntry<K, V> implements Map.Entry<K, V> {
	private K key;
	private V value;

	public MapEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		return this.value = value;
	}

	@Override
	public int hashCode() {
		return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof MapEntry))
			return false;
		MapEntry me = (MapEntry) obj;
		return (key == null ? me.key == null : key.equals(me.key))
				&& (value == null ? me.value == null : value.equals(me.value));

	}

	@Override
	public String toString() {
		return key + "=" + value;
	}

}
