package innerclass;

class WithNonDefault{
	class Inner{
		int i ;
		public Inner(int i) { this.i = i; }
		public Inner() { i = 47; }
		public void f() { System.out.println("Inner.f"); }
	}
}

interface D{
	void fun();
}

interface DFactory{
	D get();
}

class SS implements D{

	@Override
	public void fun() {
		// TODO Auto-generated method stub
		
	}
	
}

public class InnerClassInheritance {
	class Inner2 extends WithNonDefault.Inner{
		Inner2(WithNonDefault wnd){
			wnd.super();
		}
		Inner2(WithNonDefault wnd,int i){
			wnd.super(i);
		}
		@Override
		public void f() { System.out.println("Inner2.f "+i); }
	}
	public static void main(String[] args){
		WithNonDefault wnd = new WithNonDefault();
		InnerClassInheritance ici = new InnerClassInheritance();
		Inner2 i2 = ici.new Inner2(wnd);
		Inner2 i3 = ici.new Inner2(wnd,100);
		i2.f();
		i3.f();
		new D(){

			@Override
			public void fun() {
				System.out.println("BBB");
				
			}
			
		}.fun();
	}
}




