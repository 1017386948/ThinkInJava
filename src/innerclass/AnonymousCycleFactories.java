package innerclass;

interface Cycle{
	int wheels();
	void ride();
}

interface CycleFactory{
	Cycle get();
}

class Unicycle implements Cycle{

	@Override
	public int wheels() {
		return 1;
	}
	
	public void ride(){
		System.out.println("Ride Unicycle, wheels "+wheels());
	}
	
	public static CycleFactory factory = new CycleFactory() {
		
		@Override
		public Cycle get() {
			return new Unicycle();
		}
	};
}

class Bicycle implements Cycle{

	@Override
	public int wheels() {
		return 2;
	}
	
	public void ride(){
		System.out.println("Ride Bicycle, wheels "+wheels());
	}
	
	public static CycleFactory factory = new CycleFactory() {
		
		@Override
		public Cycle get() {
			return new Bicycle();
		}
	};
}

class Tricycle implements Cycle{

	@Override
	public int wheels() {
		return 3;
	}
	
	public void ride(){
		System.out.println("Ride Tricycle, wheels "+wheels());
	}
	
	public static CycleFactory factory = new CycleFactory() {
		
		@Override
		public Cycle get() {
			return new Tricycle();
		}
	};
}

public class AnonymousCycleFactories {
	public static void rideCycle(CycleFactory factory){
		Cycle c = factory.get();
		c.ride();
	}
	public static void main(String[] args){
		rideCycle(Unicycle.factory);
		rideCycle(Bicycle.factory);
		rideCycle(Tricycle.factory);
	}
}
