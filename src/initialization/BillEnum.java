package initialization;
import operators.Fibonacci;

enum Coins{
	ONE,TWO,FIVE,TEN,TWENTY;
}

public class BillEnum {
	public static void main(String[] args){
		Coins coin;
		for(Coins c: Coins.values()){
			System.out.println(c+" "+c.ordinal());
		}
		Fibonacci.fib(6);
	}
}
