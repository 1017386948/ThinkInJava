package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static net.mindview.util.Print.*;

class BlockedMutex {
	private Lock lock = new ReentrantLock();
	public BlockedMutex() {
		// Acquire it right away, to demonstrate interruption
		// of a task blocked on a ReentrantLock:
		System.out.println("BlockedMutex" + Thread.currentThread().toString());
		lock.lock();
	}
	public void f() {
		try {
			// This will never be available to a second task
			lock.lockInterruptibly(); // Special call
			print("lock acquired in f()");
		} catch (InterruptedException e) {
			print("Interrupted from lock acquisition in f()");
		}
	}
}
class Blocked2 implements Runnable {
	BlockedMutex blocked = new BlockedMutex();
	public void run() {
		System.out.println("Blocked2" + Thread.currentThread().toString());
		print("Waiting for f() in BlockedMutex");
		blocked.f();
		print("Broken out of blocked call");
	}
}
public class Interrupting2 {
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new Blocked2());
		t.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Issuing t.interrupt()");
		t.interrupt();
	}
}