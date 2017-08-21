package typeinfo;

import java.lang.reflect.Field;
import java.util.Arrays;

public class RecursiveClassPrint {

	static void printClasses(Class<?> c) {
		if (c == null)
			return;
		System.out.println(c.getName());
		for(Class<?>i: c.getInterfaces()) {
			System.out.println("Interface: " + i.getName());
			printClasses(i.getSuperclass());
		}
		printClasses(c.getSuperclass());
	}
	
	private final static int i = 100;
	private final static String s = "sss";

	public static void main(String[] args) throws ClassNotFoundException {
//		printClasses(Class.forName("java.util.ArrayList"));
//		System.out.println(Class.forName("java.util.List"));
		for(Field field:Class.forName("typeinfo.RecursiveClassPrint").getDeclaredFields())
			System.out.println(field);
	}
}
