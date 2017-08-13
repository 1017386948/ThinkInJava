package exceptions;

class Annoyance extends Exception {

}

class Sneeze extends Annoyance {

}

public class Human {
	static void throwRuntimeException(int type) {
		try {
			switch (type) {
			case 0:
				throw new Annoyance();
			case 1:
				throw new Sneeze();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args) {
		throwRuntimeException(2);
		for(int i = 0; i < 2; i++) {
			try {
			throwRuntimeException(i);
			}catch (RuntimeException e) {
				try {
					throw e.getCause();
				}catch (Sneeze e1) {
					System.out.println("Sneeze");
				}catch (Annoyance e1) {
					System.out.println("Caught Annoyance");
				}catch(Throwable t) {
					System.out.println(t);
				}
			}
		}
	}
}
