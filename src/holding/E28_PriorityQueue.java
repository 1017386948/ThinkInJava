package holding;

import java.util.*;

class Simple{}

public class E28_PriorityQueue {
	static Random rand = new Random(47);

	public static void main(String[] args) {
		PriorityQueue<Double> priorityQueue = new PriorityQueue<Double>();
		for (int i = 0; i < 10; i++)
			priorityQueue.offer(rand.nextDouble());
		System.out.println(priorityQueue);
//		PriorityQueue<Simple> prioritySimple = new PriorityQueue<Simple>();
//		prioritySimple.offer(new Simple());
//		prioritySimple.offer(new Simple());
	}

}
