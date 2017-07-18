package Interface;

abstract class NoMtd {
	
}

public class NoMtdAbs extends NoMtd{
	public void print(){
		System.out.println(this.getClass().getSimpleName());
	}
	
	public static NoMtdAbs turn(NoMtd nomthd){
		return (NoMtdAbs)nomthd;
	}
	public static void main(String[] args){
		NoMtdAbs no = new NoMtdAbs();
		 no.print();
	}
}
