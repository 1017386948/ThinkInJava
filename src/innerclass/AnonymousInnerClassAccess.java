package innerclass;

public class AnonymousInnerClassAccess {
	private int i = 10;
	private void f() {
	System.out.println("AnonymousInnerClassAccess.f");
	}
	public void h(){
		new Object(){
			void g(){
				i++;
				f();
			}
		}.g();
		System.out.println(i);
	}
	public static void main(String[] args){
		AnonymousInnerClassAccess aics = new AnonymousInnerClassAccess();
		aics.h();
	}
}
