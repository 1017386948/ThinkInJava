package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class PythonLists {
	public static void main(String[] args) {
		List<Integer> aList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(aList.getClass().getSimpleName());
		System.out.println(aList.get(4));
		aList.add(6);
		aList.addAll(Arrays.asList(7, 8));
		System.out.println(aList);
		List<Integer> aSlice = aList.subList(2, 4);
		System.out.println(aSlice);
		List<Integer> list2 = new MyArrayList(aList).getReversed();
		System.out.println(list2);
	}

}

class MyArrayList<T> extends ArrayList<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MyArrayList(Collection<? extends T> c) {
		super(c);
	}

	MyArrayList(int initialCapacity) {
		super(initialCapacity);
	}

	List<T> getReversed() {
		List<T> reversed = new MyArrayList<T>(size());
		ListIterator<T> it = listIterator(size());// ·µ»Øµü´úÆ÷
		while (it.hasPrevious()) {
			reversed.add(it.previous());
		}
		return reversed;
	}
}