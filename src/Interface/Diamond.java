package Interface;

interface BaseInterface {
	int i =100 ;
	void f();
}

interface IntermediateInterface1 extends BaseInterface {
	void f();
}

interface IntermediateInterface2 extends BaseInterface {
	void f();
}

interface CombinedInterface extends IntermediateInterface1, IntermediateInterface2 {
	void f();
}

public class Diamond{
	public static void main(String[] args){
		
		System.out.println(BaseInterface.i);
	}

	
}
