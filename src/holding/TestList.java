package holding;
import java.util.*;

class IDClass {
	private static int counter;
	private int count = counter++;

	public String toString() {
		return "IDClass " + count;
	}
}

public class TestList {
	public static void main(String[] args){
	IDClass[] idc = new IDClass[10];
	for(int i = 0;i<10;i++){
			idc[i] = new IDClass();
		}
	List<IDClass> lst = new ArrayList<IDClass>(Arrays.asList(idc));
	System.out.println("lst = " + lst);
	List<IDClass> subSet = lst.subList(1, 4);
	System.out.println("subSet = " + subSet);
	}
}
