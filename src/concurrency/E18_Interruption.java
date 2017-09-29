package concurrency;

import java.util.concurrent.TimeUnit;

class NonTask {
	static void longMethod() throws InterruptedException {
		TimeUnit.SECONDS.sleep(60);
	}
}

class Task implements Runnable {

	@Override
	public void run() {
		try {
			NonTask.longMethod();
		} catch (InterruptedException ie) {
			System.out.println(ie.toString());
		} finally {
			// Any cleanup code here...
		}
	}

}

public class E18_Interruption {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Task());
		t.start();
		TimeUnit.SECONDS.sleep(1);
		t.interrupt();
	}
}
