package innerclass;

interface WithNested {
	class Nested {
		int i;

		public Nested(int i) {
			this.i = i;
		}

		void f() {
			System.out.println("Nested.f");
		}
	}
}

class B2 implements WithNested { }

public class InterfaceWithNested {
	public static void main(String[] args){
		WithNested.Nested n = new B2.Nested(123);
		n.f();
	}

}
