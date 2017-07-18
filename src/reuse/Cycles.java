package reuse;

class Cycle{
	public static void ride(Cycle cycle){
		System.out.println(cycle.getClass());
	}
}

class Unicycle extends Cycle{
	void balance(){
		System.out.println("It's Unicycle balance.");
	}
}

class Bicycle extends Cycle{
	void balance(){
		System.out.println("It's Bicycle balance.");
	}
}

class Tricycle extends Cycle{

}

public class Cycles {
	public static void main(String[] args){
		Cycle[] c = new Cycle[4];
		c[0] = new Cycle();
		c[1] = new Unicycle();
		c[2] = new Bicycle();
		c[3] = new Tricycle();
//		((Unicycle) c[0]).balance();
		((Unicycle) c[1]).balance();
//		((Unicycle) c[2]).balance();
//		((Unicycle) c[3]).balance();
	}
}
