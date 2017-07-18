package operators;
import static net.mindview.util.Print.*;

class F {
	float f;
	
}


public class Rename{
	static void fun(F f){
		f.f = 3.0f;
	}
	public static void main(String[] args){
		F r1 = new F();
		r1.f = (float) 1.0;
		print(r1.f);
		fun(r1);
		print(r1.f);
	}
}

