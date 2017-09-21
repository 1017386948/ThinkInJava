package concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ManyTimers {
	public static void main(String[] args) throws InterruptedException {
		int numOfTimers = 1000;
		final long curr = System.currentTimeMillis();
		for (int i = 0; i < numOfTimers; i++) {
			int no = i;
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					System.out.println(
							System.currentTimeMillis() - curr + ": " + no);
				}
			}, numOfTimers - i);
		}
		TimeUnit.MILLISECONDS.sleep(3 * numOfTimers);
		System.exit(0);
	}
}
