package innerclass;

public class Outer {
	private String s;
	class Inner{
		Inner(){
			System.out.println("Inner.");
		}
		@Override
		public String toString(){
			return s;
		}
		
	}
	Inner getInner(){
		return new Inner();
	}
	
	public static void main(String[] args){
//		Outer.Inner i = new Outer().getInner();
//		System.out.println(i.toString());
		Outer o = new Outer();
//		Outer.Inner oi =  o.getInner();
		Outer.Inner oi = o.new Inner();
		System.out.println(oi.toString());
	}
	
}
