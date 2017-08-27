package arrays;

class Father{
	public int a = 0;
}

class Child extends Father{
	{
		a = 10;
	}
	{
		System.out.println(a);
	}
}

public class Test {
	public static void main(String[] args) {
//		char[] c = new char[4];
//		System.out.println((int) c[1]);
		Child c = new Child();
	}
}
