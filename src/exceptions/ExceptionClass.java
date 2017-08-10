package exceptions;

@SuppressWarnings("serial")
class MyException extends Exception {
	public String s;

	public MyException() {
	}

	public MyException(String s) {
		this.s = s;

	}
}

public class ExceptionClass {
	public static void main(String[] args) {
		try {
			throw new MyException("hehe");
		}catch (MyException e) {
			System.out.println(e.getMessage());
			System.out.println(e.s);
		}
		
	}
}
