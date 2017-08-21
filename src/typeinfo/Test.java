package typeinfo;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;

import javax.print.attribute.standard.Media;

import test.*;

/**
 * @author 10173
 *
 */

abstract class AAA {
	final void find() {
		print("AAA");
	}

	abstract void print(String s);

}

class Gum extends AAA implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Gum() {
	}

	Gum(int i) {
	}

	static {
		System.out.println("Gum loading.");
	}

	@Override
	public String toString() {
		System.out.println("hehe");
		return "";
	}

	@Override
	void print(String s) {
		System.out.println("Gum" + s);

	}

}

class Initable {
	public final static String s1 = "eheh";
	public final String s2 = "hehe";
	public static String s3;
	// static {
	// System.out.println("initial class");
	// }
}

public class Test extends Gum {
	static int i;
	int j;

	public static void main(String[] args)throws Exception {
//		try {
//			Object o = Class.forName("typeinfo.Gum").newInstance();
//			o = new Gum(1);
//			o.toString();
//			for(Class c : Class.forName("typeinfo.Gum").getInterfaces())
//				System.out.println(c.getCanonicalName());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(Initable.s3);
//		Class c = Initable.class;
//		Class<Integer> a = Integer.class;
//		c = Double.class;
//		new Test().print();
//		Class<? super Object> cls = Object.class.getSuperclass();
//		System.out.println(cls.getName());
//		
//		Class<Test> testType = Test.class;
//		Gum gum = new Test();
//		Test t = Test.class.cast(gum);
//		Test t = gum;
//		Test t = (Test)gum;
//		t.test();
//		Inner.print();
		
//		Class.forName(className);
//		System.out.println(AbstractList.class.isAssignableFrom(ArrayList.class));
		
//		A a = HiddenB.makeA();
//		System.out.println(a.getClass().getName());
//		Method m = a.getClass().getDeclaredMethod("g");
//		m.setAccessible(true);
//		m.invoke(a);
		Method[] mtds = AA.class.getDeclaredMethods();
		for(Method m:mtds) {
			m.setAccessible(true);
			m.invoke(AA.class.newInstance());
		}
	}

	public void test() {
		super.find();
	}

	@Override
	void print(String s) {
		System.out.println("Test" + s);

	}

	static class Inner {
		static void print() {
			System.out.println(j);
		}

		static int j = 5;
	}

}
