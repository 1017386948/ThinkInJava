package containers;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import net.mindview.util.Countries;

public class SimpleHashSet<E> extends AbstractSet<E> {

	final static int size = 997;
	@SuppressWarnings("unchecked")
	private LinkedList<E>[] buckets = new LinkedList[size];

	@Override
	public boolean add(E e) {
		if (e == null)
			return false;
		int index = Math.abs(e.hashCode()) % size;
		if (buckets[index] == null)
			buckets[index] = new LinkedList<E>();
		LinkedList<E> elements = buckets[index];
		ListIterator<E> it = elements.listIterator();
		while (it.hasNext()) {
			if (it.next().equals(e)) {
				return false;
			}
		}
		it.add(e);
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int count;
			private boolean canRemove;
			private int index1, index2;

			@Override
			public boolean hasNext() {

				return count < size();
			}

			@Override
			public E next() {
				if (hasNext()) {
					canRemove = true;
					++count;
					for (;;) {
						while (buckets[index1] == null)
							++index1;
						try {
							return buckets[index1].get(index2++);
						} catch (IndexOutOfBoundsException e) {
							++index1;
							index2 = 0;
						}

					}

				}
				throw new NoSuchElementException();
			}

			public void remove() {
				if (canRemove) {
					canRemove = false;
					buckets[index1].remove(--index2);
					if (buckets[index1].isEmpty()) // Housekeeping...
						buckets[index1++] = null;
					--count;
				} else
					throw new IllegalStateException();
			}

		};
	}

	@Override
	public int size() {
		int sz = 0;
		for (LinkedList<E> bucket : buckets)
			if (bucket != null)
				sz += bucket.size();
		return sz;
	}

	public static void main(String[] args) {
		SimpleHashSet<String> m = new SimpleHashSet<String>();
		m.addAll(Countries.names(10));
		m.addAll(Countries.names(10));
		System.out.println("m = " + m);
		System.out.println("m.size() = " + m.size());
		Iterator<String> it = m.iterator();
		System.out.println("it.next()= " + it.next());
		it.remove();
		System.out.println("it.next()= " + it.next());
		System.out.println("m = " + m);
		m.remove("ALGERIA");
		System.out.println("m = " + m);
	}

}
