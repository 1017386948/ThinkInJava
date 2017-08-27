package arrays;

import java.util.Arrays;

class BerylliumSphere {
	private static int count;
	private final int id = count++;

	public String toString() {
		return "BerylliumSphere " + id;
	}
}

public class ArrayInitialization {
	static void hide(BerylliumSphere[] berylliumSpheres) {
		for (BerylliumSphere b : berylliumSpheres) {
			System.out.println(b);
		}
	}

	public static void main(String[] args) {
//		hide(new BerylliumSphere[] { new BerylliumSphere(), new BerylliumSphere(), });

		BerylliumSphere[] b1 = new BerylliumSphere[] { new BerylliumSphere(), new BerylliumSphere(),
				new BerylliumSphere(), };
		BerylliumSphere[] b2 = new BerylliumSphere[3];
		System.arraycopy(b1, 0, b2, 0, 3);
		System.out.println(Arrays.toString(b1));
		System.out.println(Arrays.toString(b2));
		String[] s1 = new String[2];
		Arrays.fill(s1, "val");
		String[] s2 = new String[] {new String("val"),new String("val")};
		System.out.println(Arrays.equals(s1, s2));
		System.out.println(s1[1]==s2[1]);
		
	}
}
