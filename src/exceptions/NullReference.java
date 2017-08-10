package exceptions;

public class NullReference {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		String s = null;
		try {
			s.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
