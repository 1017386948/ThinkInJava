package initialization;

public class OverloadingVarargs {
	static void f(String...strings){
		System.out.println("first");
	}
	
	public static void main(String... args){
//		f("abc","jsj");
//		f(new String[]{"anan","jsjs"});
		for(String s:args){
			System.out.println(s);
		}
	}

}
