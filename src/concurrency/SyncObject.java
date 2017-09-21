package concurrency;

import static net.mindview.util.Print.print;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SingleSynch {
	private Lock lock = new ReentrantLock();
	public void f() {
		lock.lock();
		try {
			for (int i = 0; i < 5; i++) {
				print("f()");
				Thread.yield();
			}
		} finally {
			lock.unlock();
		}
	}

	public synchronized void g() {
		lock.lock();
		try {
			for (int i = 0; i < 5; i++) {
				print("g()");
				Thread.yield();
			}
		} finally {
			lock.unlock();
		}
	}
	public synchronized void h() {
		lock.lock();
		try {
			for (int i = 0; i < 5; i++) {
				print("h()");
				Thread.yield();
			}
		} finally {
			lock.unlock();
		}
	}
}

class TripleSynch {
	private Lock lockF = new ReentrantLock();
	private Lock lockG = new ReentrantLock();
	private Lock lockH = new ReentrantLock();
	private Object syncObjectG = new Object();
	private Object syncObjectH = new Object();
	public synchronized void f() {
		for (int i = 0; i < 5; i++) {
			print("f()");
			Thread.yield();
		}
	}
	public void g() {
		synchronized (syncObjectG) {
			for (int i = 0; i < 5; i++) {
				print("g()");
				Thread.yield();
			}
		}
	}
	public void h() {
		synchronized (syncObjectH) {
			for (int i = 0; i < 5; i++) {
				print("h()");
				Thread.yield();
			}
		}
	}
}

public class SyncObject {
	public static void main(String[] args) throws InterruptedException {
		final SingleSynch singleSync = new SingleSynch();
		final TripleSynch tripleSync = new TripleSynch();
		print("Test SingleSynch...");
		Thread t1 = new Thread() {
			public void run() {
				singleSync.f();
			}
		};
		t1.start();
		Thread t2 = new Thread() {
			public void run() {
				singleSync.g();
			}
		};
		singleSync.h();
		t2.start();
		t1.join();// Wait for t1 to finish its work
		t2.join();// Wait for t2 to finish its work
		print("Test TripleSynch...");
		new Thread() {
			public void run() {
				tripleSync.f();
			}
		}.start();
		new Thread() {
			public void run() {
				tripleSync.g();
			}
		}.start();
		tripleSync.h();
	}
}
