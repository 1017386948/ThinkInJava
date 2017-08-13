package exceptions;

import javax.management.RuntimeErrorException;

class Level1Exception extends Exception {
}

class Level2Exception extends Level1Exception {
}

class Level3Exception extends Level2Exception {
}

class A {
	public void f() throws Level1Exception {
		throw new Level1Exception();
	}
}

class B extends A {
	public void f() throws Level2Exception {
		throw new Level2Exception();
	}
}

class C extends B {
	public void f() throws Level3Exception {
		throw new Level3Exception();
	}
}

public class ThreeLevelExceptions {
	public static void main(String[] args){
		A c = new C();
		try {
			c.f();
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}
}
