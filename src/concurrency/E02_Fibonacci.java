package concurrency;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.mindview.util.Generator;

class Fibonacci implements Runnable, Generator<Integer> {
	private int count;
	private final int n;

	public Fibonacci(int n) {
		this.n = n;
	}

	private static int fib(int i) {
		if (i < 2)
			return 1;
		return fib(i - 1) + fib(i - 2);
	}

	@Override
	public Integer next() {
		return fib(count++);

	}

	@Override
	public void run() {
		Integer[] sequence = new Integer[n];
		for (int i = 0; i < n; i++) {
			sequence[i] = next();
		}
		System.out.println("Seq. of " + n + ": " + Arrays.toString(sequence));
		Thread.yield();
	}

}

public class E02_Fibonacci {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 1; i <= 5; i++) {
			// new Thread(new Fibonacci(i)).start();
			exec.execute(new Fibonacci(i));
		}
		Thread.yield();
		exec.shutdown();
	}
}
