package arrays;

import java.util.Arrays;

public class ReturningArray {
	static BerylliumSphere[] createArray(int i) {
		BerylliumSphere[] sphere = new BerylliumSphere[i];
		for(int n = 0;n<i;n++) {
			sphere[n] = new BerylliumSphere();
		}
		return sphere;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(createArray(5)));
	}
}
