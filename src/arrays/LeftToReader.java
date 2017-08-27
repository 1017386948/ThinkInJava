package arrays;

import java.lang.reflect.Array;
import java.util.*;

public class LeftToReader {

	// @SuppressWarnings("unchecked")
	public LeftToReader(int size) {
		// array = new T[size]; cannot create a generic array
		// array = (T[]) new Object[size];
	}

	public static void main(String[] args) {
		ArrayList<List<String>> array;
		array = new ArrayList<List<String>>();
		array.add(new ArrayList<String>());
		System.out.println(array.get(0).add("Array of Generics"));// List add()方法返回的是boolean类型，表示插入是否成功
		System.out.println(array.toString());
		float f = 1.0f;
		f += 1.0;
		double d = 1.0;
		d = d + 1.0;
		// for(BerylliumSphere
		// b:(BerylliumSphere[])Array.newInstance(BerylliumSphere.class, 5))
		// System.out.println(b);
		// try {
		// System.out.println(BerylliumSphere.class.newInstance());
		// } catch (InstantiationException | IllegalAccessException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		int i;
		Integer in = 5;
		i = in;
		System.out.println(in == Integer.valueOf(5));
		int[] ii = new int[] { 3, 5, 1, 5, 32, 4, 77 };
		int[] jj = new int[10];
		Arrays.sort(ii);
		System.out.println(Arrays.toString(ii));
		Arrays.asList(ii);
		System.arraycopy(ii, 3, jj, 0, 4);
		System.out.println(Arrays.toString(jj));
		Arrays.sort(ii);
	}
}
