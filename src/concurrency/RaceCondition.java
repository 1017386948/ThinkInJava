package concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Tank {
	enum State {
		EMPTY, LOADED
	}

	private State state = State.EMPTY;
	private int current_load = 0;

	public void validate() {
		if ((state == State.EMPTY && current_load != 0)
				|| (state == State.LOADED && current_load == 0))
			throw new IllegalStateException();
	}
	public void fill() {
		state = State.LOADED;
		Thread.yield();
		current_load = 10;
	}
	public void drill() {
		state = State.EMPTY;
		Thread.yield();
		current_load = 0;
	}

}

class MyTank extends Tank {
	public synchronized void validate() {
		super.validate();
	}
	public synchronized void fill() {
		super.fill();
	}
	public synchronized void drill() {
		super.drill();
	}
}

class ConsistencyChecker implements Runnable {
	private static Random rnd = new Random();
	private Tank tank;
	ConsistencyChecker(Tank tank) {
		this.tank = tank;
	}
	@Override
	public void run() {
		for (;;) {
			if (rnd.nextBoolean())
				tank.fill();
			else
				tank.drill();
			tank.validate();
		}
	}

}

public class RaceCondition {
	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(
				new MyUncaughtExceptionHandler());
		System.out.println("Press Control-C to exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		// Tank tank = new Tank();
		MyTank myTank = new MyTank();
		for (int i = 0; i < 10; i++) {
			exec.execute(new ConsistencyChecker(myTank));
		}
		Thread.yield();
		exec.shutdown();
	}
}
