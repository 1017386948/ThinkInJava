package operators;
import static net.mindview.util.Print.*;

public class Fibonacci {
	public static int[] fib(int i){
		if(i>0){
			int[] f = new int[i];
			switch(i){
			case 1:
				f[0] = 1;
				break;
			case 2:
				f[0] = f[1] = 1;
				break;
			default:
				f[0] = f[1] = 1;
				for(int k = 2;k<i;k++){
					f[k] = f[k-1]+f[k-2];
				}
			}
			return f;
		}
		return null;
		
	}
	
	public static void main(String[] args){
		for(int i:fib(15)){
			printnb(i+" ");
		}
	}
}
