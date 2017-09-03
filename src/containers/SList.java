package containers;

interface SListIterator<T> {
	boolean hasNext();

	T next();

	void remove();

	void add(T element);
}

public class SList<T> {
	private final Link<T> header = new Link<T>(null, null);

	public SList() {
		header.next = header;
	}

	private static class Link<T> {
		T element;
		Link<T> next;

		Link(T element, Link<T> next) {
			this.element = element;
			this.next = next;
		}
	}

	private class SListIteratorImpl implements SListIterator<T> {
		private final Link<T> header = new Link<T>(null, null);
		private Link<T> next;

		public SListIteratorImpl() {
			next = header.next;
		}

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public T next() {
			return null;
		}

		@Override
		public void remove() {

		}

		@Override
		public void add(T element) {

		}

	}

}
