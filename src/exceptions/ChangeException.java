package exceptions;

class AnException extends Exception {
}

class AnotherException extends Exception {
}

public class ChangeException {
	static void f() throws RuntimeException {
		try {
			g();
		} catch (AnException e) {
			throw new RuntimeException(e);	
		}
	}

	static void g() throws AnException {
		throw new AnException();
	}
	public static void main(String[] args) throws Exception {
//		g();
		f();
	}
}
