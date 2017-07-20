package innerclass;

class Outer3{
	class Inner{
		{System.out.println("Inner created");}
	}
}

public class InstanceOfInner {
	public static void main(String[] args) {
		Outer3 o = new Outer3();
		o.new Inner();
	}
}
