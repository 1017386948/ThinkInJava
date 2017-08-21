package test;



class B implements A{

	@Override
	public void f() {
		System.out.println("public B.f");
	}
	
	public void g() {
		System.out.println("public B.f");
	}
	
}

public class HiddenB {
	public static A makeA() {
		return new B();
	}
}
