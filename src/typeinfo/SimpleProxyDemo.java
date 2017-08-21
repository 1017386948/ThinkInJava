package typeinfo;

import static net.mindview.util.Print.*;

interface Interface {
	void doSomething();

	void somethingElse(String arg);
}

class RealObject implements Interface {
	public void doSomething() {
		print("doSomething");
	}

	public void somethingElse(String arg) {
		print("somethingElse " + arg);
	}
}

class SimpleProxy implements Interface {
	
	static int count;
	private Interface proxied;
	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}
	@Override
	public void doSomething() {
		++count;
		proxied.doSomething();
		print(count);
	}

	@Override
	public void somethingElse(String arg) {
		++count;
		proxied.somethingElse(arg);
		print(count);
	}

}

public class SimpleProxyDemo {

}
