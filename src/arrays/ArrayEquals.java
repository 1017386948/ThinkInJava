package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

class DataHolder implements Comparable<DataHolder> {
	protected int data;

	DataHolder(int data) {
		this.data = data;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj instanceof DataHolder && this.data == ((DataHolder) obj).data;
	}

	@Override
	public int compareTo(DataHolder o) {
		return this.data < o.data ? -1 : (this.data == o.data ? 0 : 1);
	}

	@Override
	public String toString() {
		return "DataHolder " + data;
	}
}

public class ArrayEquals {
	static Random rand = new Random(47);
	static DataHolder[][] d1 = new DataHolder[][] { { new DataHolder(1), new DataHolder(2), },
			{ new DataHolder(1), new DataHolder(2), } };
	static DataHolder[][] d2 = new DataHolder[][] { { new DataHolder(1), new DataHolder(2), },
			{ new DataHolder(1), new DataHolder(2), } };
	static DataHolder[] d3 = new DataHolder[] { new DataHolder(rand.nextInt(100)), new DataHolder(rand.nextInt(100)),
			new DataHolder(rand.nextInt(100)), new DataHolder(rand.nextInt(100)), new DataHolder(rand.nextInt(100)),
			new DataHolder(rand.nextInt(100)), new DataHolder(rand.nextInt(100)), new DataHolder(rand.nextInt(100)), };

	public static void main(String[] args) {
//		System.out.println(Arrays.deepEquals(d1, d2));
//		Arrays.sort(d3);
//		System.out.println(Arrays.toString(d3));
		Random rand = new Random(47);
		int[] array = new int[10];
		for(int i = 0;i<10;i++) {
			array[i] = rand.nextInt(100);
		}
		System.out.println(Arrays.toString(array));
//		Arrays.sort(array);
//		System.out.println(Arrays.toString(array));
//		System.out.println(Arrays.binarySearch(array, 29));
		Integer[] in = new Integer[20];
		for(int i = 0;i<20;i++) {
			in[i] = rand.nextInt(100);
		}
		System.out.println(Arrays.toString(in));
		Arrays.sort(in, Collections.reverseOrder());
		System.out.println(Arrays.toString(in));
		
	}

}
