package concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SleepingTask implements Runnable {
	private static Random rnd = new Random(47);
	private final int sleep_time = rnd.nextInt(3);

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(sleep_time);
		} catch (InterruptedException e) {
			System.err.println("Interrupted: " + e);
		}
		System.out.println(sleep_time);
	}

}

public class E06_SleepingTask {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new SleepingTask());
		}
		Thread.yield();
		exec.shutdown();
	}
}
