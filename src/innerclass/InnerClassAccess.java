package innerclass;

public class InnerClassAccess {
	private int i;
	private void f(){
		System.out.println("E07_InnerClassAccess.f");
	}
	
	class Inner {
		private int j = 10;
		private void fun(){
			System.out.println("hehe.");
		}
		void g(){
			i++;
			f();
		}
	}
	
	public void test(){
		Inner i = new Inner();
		System.out.println(i.j);
		i.fun();
	}
	public static void main(String[] args){
		InnerClassAccess ica = new InnerClassAccess();
		InnerClassAccess.Inner ii = ica.new Inner();
		ii.g();
		System.out.println(ica.i);
		ica.test();
	}

}
