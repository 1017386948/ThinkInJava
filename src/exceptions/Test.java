package exceptions;

public class Test {
	public static void main(String[] args) {
		try {
			throw new Exception();
		} catch (Exception e) {
		} finally {
			System.out.println("AAAAAA");
		}
		
		System.out.println("======");
		try {
			System.out.println("BBBBB");
			throw new Exception();
		} catch (Exception e) {
		} finally {
			System.out.println("CCCCCC");
		}
	}
}
