package access;

class A{
	A(int i){System.out.println("Constructor A."+i);}
}

class B{
	B(){System.out.println("Constructor B.");}
}

public class C extends A{
	C(int i){
		super(i);
	}
	B b = new B();
	public static void main(String[] args){
		new C(1);
	}
}
