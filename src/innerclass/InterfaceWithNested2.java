package innerclass;

interface I{
	void f();
	void g();
	static class Nested{
		static void call(I impl){
			System.out.println("Calling I.f()");
			impl.f();
			System.out.println("Calling I.g()");
			impl.g();
		}
	}
}

public class InterfaceWithNested2 {
	public static void main(String[] args){
		I.Nested.call(new I(){

			@Override
			public void f() {
				System.out.println("Calling impl.f()");
			}

			@Override
			public void g() {
				System.out.println("Calling impl.g()");
			}
			
		});
	}
}
