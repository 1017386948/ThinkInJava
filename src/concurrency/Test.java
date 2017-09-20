package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class Test {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		ExecutorService exec = Executors
				.newCachedThreadPool(new HandlerThreadFactory());
		exec.execute(new ExceptionThread());
		Future<String> f;
		System.out.println(1 | 0x00000001);
	}
}

class HandlerThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		return t;
	}

}

class ExceptionThread implements Runnable {

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println(t);
		throw new RuntimeException();
	}

}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("catch " + e);
	}

}