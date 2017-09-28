package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static net.mindview.util.Print.*;

class Count {
	private int count = 0;
	private Random rand = new Random(47);
	public synchronized int increment() {
		int temp = count;
		if (rand.nextBoolean())
			Thread.yield();
		return (count = ++temp);
	}
	public synchronized int value() {
		return count;
	}
}

class Sensor implements Runnable {
	private static Random rand = new Random(47);
	private static Count count = new Count();
	private static List<Sensor> sensors = new ArrayList<>();
	private int num = 0;
	private final int id;
	private static volatile boolean isCanceled = false;
	public static void cancel() {
		isCanceled = true;
	}
	public Sensor(int id) {
		this.id = id;
		sensors.add(this);
	}
	@Override
	public void run() {
		while (!isCanceled) {
			if (rand.nextInt(5) == 0) {
				synchronized (this) {
					++num;
				}
				count.increment();
			}
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("sleep interrupted");
			}
		}
	}

	public synchronized int getValue() {
		return num;
	}

	public String toString() {
		return "Sensor " + id + ": " + getValue();
	}

	public static int getTotalCount() {
		return count.value();
	}

	public static int sumSensors() {
		int sum = 0;
		for (Sensor s : sensors)
			sum += s.getValue();
		return sum;
	}

}

public class RadiationCounter {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
			exec.execute(new Sensor(i));
		TimeUnit.SECONDS.sleep(3);
		Sensor.cancel();
		exec.shutdown();
		if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
			print("Some tasks were not terminated!");
		print("Total: " + Sensor.getTotalCount());
		print("Sum of Sensors: " + Sensor.sumSensors());
	}
}
