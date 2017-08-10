package exceptions;

class ResumerException extends Exception {

}

class Resumer {
	static int count = 4;

	static void f() throws ResumerException {
		if (--count > 0)
			throw new ResumerException();
	}
}

public class Resumption {
	public static void main(String[] args) {
		while(true) {
			try {
				Resumer.f();
			}catch (ResumerException e) {
				System.out.println("Caught " + e);
				continue;
			}
			System.out.println("Got through...");
			break;
		}
	}
}
