package Interface;

abstract class NoAbstractMtd{
	NoAbstractMtd(){
		print();
	}
	public abstract void  print();
}

public class NoAbstract extends NoAbstractMtd{
	public static void main(String[] args){
		new NoAbstract();
	}
	
	private int i = 5; 

	@Override
	public void print() {
		System.out.println(i+" hundred miles ");
		
	}
}
