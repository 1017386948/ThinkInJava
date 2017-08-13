package exceptions;

public class NullReference {

	@SuppressWarnings("null")
	public static void main(String[] args) throws NullPointerException,Exception{
		String s = null;
		try {
			s.toString();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
