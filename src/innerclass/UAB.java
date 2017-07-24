package innerclass;

interface U{
	void f();
	void g();
	void h();
}

class A{
	U getU(){
		return new U(){

			@Override
			public void f() {System.out.println("A.f");}

			@Override
			public void g() {System.out.println("A.g");}

			@Override
			public void h() {System.out.println("A.h");}
		};
	}
}

class B{
	U[] ua;
	public B(int size){
		ua = new U[size];
	}
	public boolean add(U u){
		for(int i = 0;i<ua.length;i++){
			if(ua[i]==null){
				ua[i] = u;
				return true;
			}
		}
		return false;
	}
	public boolean setNull(int i){
		if(i<0||i>=ua.length){
			return false;
		}
		ua[i] = null;
		return true;
	}
	public void callMethods(){
		for(int i = 0;i<ua.length;i++){
			if(ua[i]!=null){
				ua[i].f();
				ua[i].g();
				ua[i].h();
			}
		}
	} 
}


public class UAB {
	public static void main(String[] args){
		A[] aa = { new A(), new A(), new A() };
		B b = new B(3);
		for(int i = 0; i < aa.length; i++)
			b.add(aa[i].getU());
		b.callMethods();
		System.out.println("****");
		b.setNull(1);
		b.callMethods();
	}
}
