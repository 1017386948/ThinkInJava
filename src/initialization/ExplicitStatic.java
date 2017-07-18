package initialization;

class Cup{
	Cup(){
		System.out.println(s1+" "+s2);
	}
	String s1;
	String s2;
	{
	s1 = "abc";
	s2 = "hehe";
	System.out.println("nnnn");
	}
}

public class ExplicitStatic {
	public static void main(String[] args){
		new Cup();
	}
}
