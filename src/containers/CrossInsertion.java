package containers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.mindview.util.Countries;

public class CrossInsertion {
	static ArrayList<String> al = new ArrayList<>(Countries.names(5));
	static LinkedList<String> ll = new LinkedList<>(Countries.names(10).subList(5, 10));

	public static void main(String[] args) {
		print(al);
		System.out.println();
		print(ll);
	}

	public static <T> void print(List<T> list) {
		Iterator<T> iter = list.iterator();
		while (iter.hasNext())
			System.out.print(iter.next()+" ");

	}
	
	
}
