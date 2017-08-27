package arrays;

import java.util.Arrays;
import java.util.Random;

public class TwoDDoubleArray {
	static double[][] twoDDoubleArray(int xLen, int yLen, double valStart, double valEnd) {
		Random rand = new Random(47);
		double[][] array = new double[xLen][yLen];
		for (int i = 0; i < xLen; i++) {
			for (int j = 0; j < yLen; j++) {
				array[i][j] = rand.nextDouble() * (valEnd - valStart) + valStart;
			}
		}
		return array;
	}

	static void printArray(double[][] array) {
		for (double[] d1 : array) {
			System.out.print("[");
			for (double d2 : d1) {
				System.out.printf("%.2f ",d2);
			}
			
			System.out.print("]");
		}
		System.out.println();
	}
	
	static BerylliumSphere[][] twoDIntArray(int xLen, int yLen) {
		BerylliumSphere[][] array = new BerylliumSphere[xLen][yLen];
		for (int i = 0; i < xLen; i++) {
			for (int j = 0; j < yLen; j++) {
				array[i][j] = new BerylliumSphere();
			}
		}
		return array;
	}

	public static void main(String[] args) {
		printArray(twoDDoubleArray(2, 3, 1.33, 3.5));
		printArray(new double[2][3]);
		System.out.println(Arrays.deepToString(new Object[2][3]));
		System.out.println(Arrays.deepToString(twoDIntArray(2,3)));
	}
}
