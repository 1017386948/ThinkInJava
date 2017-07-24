package innerclass;

class NoDefault {
	private int i;

	public NoDefault(int i) {
		this.i = i;
	}

	public void f() {
		System.out.println("NoDefault.f "+i);
	}
}

class Second{
	public NoDefault get1(int i) {
		// Doesn't override any methods:
		return new NoDefault(i) {};
		}
		public NoDefault get2(int i) {
		// Overrides f():
		return new NoDefault(i) {
		public void f() {System.out.println("Second.get2.f "+i);}};
	}
}

public class ReturningAnonymousIC {
	public static void main(String[] args){
		Second s = new Second();
		NoDefault nd = s.get1(100);
		nd.f();
		nd = s.get2(200);
		nd.f();
	}
}
