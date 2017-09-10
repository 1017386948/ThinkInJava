package enumerated;

import static enumerated.Shrubbery.GROUND;

import java.lang.reflect.Type;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) throws Throwable {
		Shrubbery sb = Shrubbery.GRAWLING;
		switch (sb) {
		case GROUND:
			System.out.println(GROUND);
		default:
			break;
		}
		for (Type t : Enum.class.getGenericInterfaces()) {
			System.out.println(t.getTypeName());
		}
		System.out.println(new en() {
			@Override
			public String f() {
				return "Overriden method.";
			}
		}.toString());
	}
}

class en {
	public String f() {
		return "default method.";
	}

	@Override
	public String toString() {
		return f();
	}
}