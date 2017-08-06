package holding;

import java.util.*;

class Command{
	private final String cmd;
	public Command(String cmd){
		this.cmd = cmd;
	}
	public String Operation() {
		return cmd;
	}
}

class Producer{
	public static void produce(Queue<Command> q) {
		q.offer(new Command("load"));
		q.offer(new Command("delete"));
		q.offer(new Command("save"));
		q.offer(new Command("exit"));
	}
}

class Consumer{
	public static void consume(Queue<Command> q) {
		while(!q.isEmpty()) {
			System.out.println(q.poll().Operation());
		}
	}
}

public class CommandQueue {
	public static void main(String[] args) {
		Queue<Command> q = new LinkedList<Command>();
		Producer.produce(q);
		Consumer.consume(q);
	}
}
