package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Printer implements Runnable {
	private static int taskCount;
	private final int id = taskCount++;

	Printer() {
		System.out.println("Printer started, ID = " + id);
	}

	public void run() {
		System.out.println("Stage 1..., ID = " + id);
		Thread.yield();
		System.out.println("Stage 2..., ID = " + id);
		Thread.yield();
		System.out.println("Stage 3..., ID = " + id);
		Thread.yield();
		System.out.println("Printer ended, ID = " + id);
	}
}

public class E03_Runnable {
	public static void main(String[] args) {
		ExecutorService exec;
		// exec = Executors.newCachedThreadPool();
		// for (int i = 0; i < 5; i++)
		// exec.execute(new Printer());
		// Thread.yield();
		// exec.shutdown();
		// exec = Executors.newFixedThreadPool(5);
		// for (int i = 0; i < 5; i++)
		// exec.execute(new Printer());
		// Thread.yield();
		// exec.shutdown();
		exec = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++)
			exec.execute(new Printer());
		Thread.yield();
		exec.shutdown();
	}
}
