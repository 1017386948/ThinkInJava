package holding;

import java.util.LinkedList;
import java.util.ListIterator;

public class MiddleInsertion {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		ListIterator<Integer> it = list.listIterator();
		for(int i = 1;i<=10;i++) {
			it.add(i);
			if(i%2==0) {
				System.out.print(it.previous()+" ");
			}
				
		}
		System.out.println("\n"+list);
	}
}
