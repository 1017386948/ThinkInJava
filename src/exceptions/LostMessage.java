package exceptions;

class YetAnotherException extends Exception {
	public String toString() {
		return "Yet another exception";
	}
}

class VeryImportantException extends Exception {
	public String toString() {
		return "A Very important exception";
	}
}

class HoHumException extends Exception {
	public String toString() {
		return "A trivial exception";
	}
}

public class LostMessage {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	void dispose() throws HoHumException {
		throw new HoHumException();
	}

	void cleanup() throws YetAnotherException {
		throw new YetAnotherException();
	}

	public static void main(String[] args) {
		try {
			LostMessage lm = new LostMessage();
			try {
				try {
					lm.f();
				} catch (Exception e) {
					System.out.println(e);
				} finally {
					lm.dispose();
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				lm.cleanup();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
