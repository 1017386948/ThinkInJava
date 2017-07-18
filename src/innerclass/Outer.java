package innerclass;

public class Outer {
	class Inner{
		Inner(){
			System.out.println("Inner.");
		}
		
	}
	Inner getInner(){
		return new Inner();
	}
	
	public static void main(String[] args){
		Outer o = new Outer();
		Outer.Inner i = o.getInner();
	}
	
}
