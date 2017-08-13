package strings;

class A{
	A(String s){
		this.s = s;
	}
	public String s ;
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		return sb.toString();
	}
}

public class Test {
	StringBuilder sb;
	StringBuffer sb2;
	public static void f(String s) {
		s = "hehe";
	}
	public static void g(A a) {
		a.s = "hehe";
	}
	public static void main(String[] args) {
//		String s = "AAA";
//		f(s);
		A a = new A("BBB");
		g(a);
		System.out.println(a);
	}
}
