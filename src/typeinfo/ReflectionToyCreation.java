package typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class SuperToy {
	int IQ;

	private SuperToy(int intelligence) {
		IQ = intelligence;
	}

	public String toString() {
		return "I'm a SuperToy. I'm smarter than you.";
	}
}

public class ReflectionToyCreation {

	public static SuperToy makeToy(String toyname, int IQ){
		try {
			Class<?> tClass = Class.forName(toyname);
			Constructor c = tClass.getDeclaredConstructor(int.class);
			c.setAccessible(true);
//			for(;;) {
//				Class<?>[] param = c.getParameterTypes();
//				if(param.length==1)
//					if(param[0]==int.class) {
//						return (SuperToy)c.newInstance(IQ);
//					}
				
//				System.out.println(c.getName());
				
				return (SuperToy)c.newInstance(IQ);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
		
	}
	public static void main(String[] args) {

		System.out.println(makeToy("typeinfo.SuperToy",150));
	}

}
