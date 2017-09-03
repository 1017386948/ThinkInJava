package containers;

import java.util.PriorityQueue;
import java.util.Random;

import containers.E11_PriorityQueue.Item;

public class E11_PriorityQueue extends PriorityQueue<Item> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static class Item implements Comparable<Item> {
		private static Random rand = new Random(47);
		private Integer priority = rand.nextInt(100);

		@Override
		public int compareTo(Item o) {
			return this.priority > o.priority ? 1 : (this.priority == o.priority ? 0 : -1);
		}
		@Override
		public String toString() {
			return priority.toString();
		}
	}

	public static void main(String[] args) {
		E11_PriorityQueue priorityQueue = new E11_PriorityQueue();
		for(int i = 0; i < 10; i++)
			priorityQueue.add(new Item());
		Item item;
		while((item = priorityQueue.poll())!=null)
			System.out.print(item+" ");
		
	}
}
