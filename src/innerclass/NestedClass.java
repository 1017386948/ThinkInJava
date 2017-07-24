package innerclass;

public class NestedClass {
	static class Nested{
		void f() { System.out.println("Nested.f"); }
		 public static class DulNested{
			void f() { System.out.println("DulNested.f"); }
		}
	}
	
	public static void main(String[] args){
		Nested n = new Nested();
		n.f();
		Nested.DulNested dn = new Nested.DulNested();
		dn.f();
	}
}
