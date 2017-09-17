package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import net.mindview.util.Generator;

class FibonacciSum implements Callable<Integer>, Generator<Integer> {
	private int count;
	private final int n;

	public FibonacciSum(int n) {
		this.n = n;
	}

	public Integer next() {
		return fib(count++);
	}

	private int fib(int n) {
		if (n < 2)
			return 1;
		return fib(n - 2) + fib(n - 1);
	}

	public Integer call() {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += next();
		return sum;
	}

}

public class E05_FibonacciSum {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<Integer>> results = new ArrayList<>();
		for (int i = 1; i <= 5; i++)
			results.add(exec.submit(new FibonacciSum(i)));
		Thread.sleep(2000);
		Thread.yield();
		exec.shutdown();
		for (Future<Integer> fs : results)
			try {
				System.out.println(fs.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
	}
}
