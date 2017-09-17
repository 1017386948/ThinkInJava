package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class PriorityThreadFactory implements ThreadFactory {
	private final int priority;

	public PriorityThreadFactory(int priority) {
		this.priority = priority;
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setPriority(priority);
		return t;
	}
}

class SimplePriorities implements Runnable {
	private int countDown = 5;
	private volatile double d;

	public String toString() {
		return Thread.currentThread() + ": " + countDown;
	}

	@Override
	public void run() {
		for (;;) {
			for (int i = 1; i < 100000; i++) {
				d += (Math.PI + Math.E) / i;
				if (i % 1000 == 0)
					;
			}
			System.out.println(this);
			if (--countDown == 0)
				return;
		}
	}

}

public class SimplePrioritiesTF {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MIN_PRIORITY));
		for (int i = 0; i < 5; i++)
			exec.execute(new SimplePriorities());
		Thread.yield();
		exec.shutdown();
		exec = Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MAX_PRIORITY));
		exec.execute(new SimplePriorities());
		Thread.yield();
		exec.shutdown();
	}
}
