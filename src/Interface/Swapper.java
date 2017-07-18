package Interface;
import static net.mindview.util.Print.*;

interface Processor{
	public String name() ;
	public String process(Object input);
}

class CharacterPairSwapper {
	static String swap(String s) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < sb.length() - 1; i += 2) {
			char c1 = sb.charAt(i);
			char c2 = sb.charAt(i + 1);
			sb.setCharAt(i, c2);
			sb.setCharAt(i + 1, c1);
		}
		return sb.toString();
	}
}

class SwapperAdapter implements Processor {
	public String name() {
		return CharacterPairSwapper.class.getSimpleName();
	}

	public String process(Object input) {
		return CharacterPairSwapper.swap((String) input);
	}
}

class Apply{
	public static void process(Processor p,Object s){
		print("Using Process "+p.name());
		print(p.process(s));
	}
}

public class Swapper {
	public static void main(String[] args) {
		Apply.process(new SwapperAdapter(), "1234");
		Apply.process(new SwapperAdapter(), "abcde");
	}
}
