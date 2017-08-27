package generics;

import java.lang.reflect.Array;
import java.util.List;

interface Top {
	void a();

	void b();
}

class CombinedImpl implements Top {
	public void a() {
		System.out.println("Top::a()");
	}

	public void b() {
		System.out.println("Top::b()");
	}

	public void c() {
		System.out.println("CombinedImpl::c()");
	}
}

public class Bounds {
	static <T extends Top> void f(T object) {
		object.a();
		object.b();
	}

	public static void main(String[] args) {
		f(new CombinedImpl());
		System.out.println(Array.newInstance(String.class, 5));
	}
}
