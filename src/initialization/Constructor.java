package initialization;

public class Constructor {
	Constructor(){
		System.out.println("It's a default constructor.");
	}
	Constructor(String s){
//		this.s=s;
		System.out.println(s+" ");
	}
//	static {String s1="hello";
//	System.out.println(s1+" ");
//	}
	void bark(int i){
		System.out.println("barking");
	}
	void bark(String s){
		System.out.println("howling");
	}
	void fun1(int i,String s){
		System.out.println(i+s);
	}
	void fun1(String s,int i){
		System.out.println(s+i);
	}
	public static void main(String[] args){;
		new Constructor();
		Constructor c = new Constructor("world");
		c.bark(1);
		c.bark("abc");
		c.fun1(10, "abc");
		c.fun1("abc", 1);
	}
}
