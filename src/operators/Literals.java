package operators;
import static net.mindview.util.Print.*;

public class Literals {
	public static void main(String[] args){
		int i1 = 0x2f;
		print("i1: "+Integer.toBinaryString(i1));
		long l1 = 8219;
		long l2 = 0x123;
		long l3 = 072L;
		print("l1: "+Long.toBinaryString(l1));
		print("l2: "+Long.toBinaryString(l2));
		print("l3: "+Long.toBinaryString(l3));
		
	}
}
