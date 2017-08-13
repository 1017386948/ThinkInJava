package exceptions;

class Except1 extends Exception{}

class BaseWithException{
	public BaseWithException() throws Except1 {
		throw new Except1() {};
	}
}

public class ConstructorExceptions extends BaseWithException{

	public ConstructorExceptions() throws Except1 {
			super();

	}
	
	public static void main(String[] args) {
		try {
			new ConstructorExceptions();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("finally");
		}
	}
}
