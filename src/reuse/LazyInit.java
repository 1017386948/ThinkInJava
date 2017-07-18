package reuse;
import operators.Villain;

class Class1{
	void doh(int i){
		System.out.println(i);
	}
	
	String s;
}

public class LazyInit extends Villain{

	void doh(String s){
		System.out.println(s);
	}
	public static void main(String[] args){
		new LazyInit();
//		new Villain();
	}
}
