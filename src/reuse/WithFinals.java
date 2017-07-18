package reuse;

 class Finals{
	 public static void f(){
		System.out.println("Finals.f().");
	}
	 public static  int i = getInt();
	 
	 static int getInt(){
		 System.out.println("static data.");
		 return 100;
	 }
	 
	 static{
		 System.out.println("static block.");
	 }
}

public class WithFinals {

	public static void main(String[] args){
		Finals.f();
	}
}


