package exceptions;

public class SimpleException {

	public static void main(String[] args) {
		try {
			throw new Exception("hehe");
		} catch (Exception e) {
			System.out.println("e.getMessage = " + e.getMessage());
		} finally {
			System.out.println("finally");
		}
	}

}
