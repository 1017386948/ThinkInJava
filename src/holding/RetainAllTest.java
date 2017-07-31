package holding;
import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class RetainAllTest {
	public static void main(String[] args){
		List<String> l1 = new ArrayList<>();
		List<String> l2 = new ArrayList<>();
		String[] food={"eggs","bacon","lettuce","beef","pork","chicken"};
		for(int i = 0;i<5;i++){
			l1.add(food[i]);
			l2.add(food[i]);
		}
		l2.add("baozi");
		System.out.println(l1.retainAll(l2));
	}
}
