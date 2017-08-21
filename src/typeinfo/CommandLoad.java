package typeinfo;
import static net.mindview.util.Print.*;

class Candy {
	static {
		print("Loading Candy");
	}
}

class Gum1 {
	static {
		print("Loading Gum");
	}
}

class Cookie {
	static {
		print("Loading Cookie");
	}
}

public class CommandLoad {
	public static void main(String[] args) throws Exception {
		for (String arg : args)
			Class.forName(arg);
	}
}