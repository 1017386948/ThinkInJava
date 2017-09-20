package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
	private int i = 0;
	public synchronized int getValue() {
		return i;
	}
	private synchronized void eventIncrement() {
		i++;
		i++;
	}
	@Override
	public void run() {
		while (true)
			eventIncrement();
	}
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomicityTest at = new AtomicityTest();
		exec.execute(at);
		while (true) {
			int val = at.getValue();
			if ((val & 0x000000001) != 0) {
				System.out.println(val);
				System.exit(0);
			}
		}
	}

}
