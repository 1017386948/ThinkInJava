package exceptions;

public class ArrayIndexBounds {
	public static void main(String[] args) {
		int[] i = {1,2};
		try {
			System.out.println(i[100]);
		}catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
}
