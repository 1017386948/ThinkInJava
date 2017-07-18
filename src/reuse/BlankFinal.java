package reuse;

public class BlankFinal {
	public static final int i ;
	public final int j;
	BlankFinal(){
		j =2;
	}
	static {
		i=1;
	}
	public  void print(){
		System.out.println("i = "+i+"\nj = "+j);
	}
	public static void main(String[] args){
		BlankFinal bf = new BlankFinal();
		bf.print();
	}
}
