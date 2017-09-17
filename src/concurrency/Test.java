package concurrency;

import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		Executors.newCachedThreadPool();
		Executors.newFixedThreadPool(10);
		Executors.newSingleThreadExecutor();
	}
}
