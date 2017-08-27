package generics;

class Manipulator<T extends HsaF> {
	private T obj;

	Manipulator(T t) {
		obj = t;
	}

	public void manipulate() {
		obj.f();
	}
}

interface HsaF {
	void f();
}

public class Test {
	public static void main(String[] args) {
		new Manipulator<>(new HsaF() {

			@Override
			public void f() {
				System.out.println("TODO Auto-generated method stub");
			}

		}).manipulate();
	}
}
