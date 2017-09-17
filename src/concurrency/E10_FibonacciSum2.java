package concurrency;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FibonacciSum2 {
	private static ExecutorService exec;

	private static int fib(int i) {
		if (i < 2)
			return 1;
		return fib(i - 1) + fib(i - 2);
	}

	public static Future<Integer> runTask(int n) {
		assert exec != null;
		return exec.submit(new Callable<Integer>() {

			@Override
			public Integer call() {
				int sum = 0;
				for (int i = 0; i < n; i++)
					sum += fib(i);
				return sum;
			}

		});
	}

	public static void init() {
		if (exec == null)
			exec = Executors.newCachedThreadPool();
	}

	public static void shutdown() {
		if (exec != null)
			exec.shutdown();
		exec = null;
	}

}

public class E10_FibonacciSum2 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
		FibonacciSum2.init();
		for (int i = 1; i <= 5; i++) {
			results.add(FibonacciSum2.runTask(i));
		}
		Thread.yield();
		FibonacciSum2.shutdown();
		for (Future<Integer> f : results)
			System.out.print(f.get() + " ");
	}
}
