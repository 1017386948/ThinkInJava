package holding;

import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import net.mindview.util.TextFile;

public class ListTesting{
	public  static <E> void loopList(List<E> list) {
		long time1 = System.currentTimeMillis(); 
		for(int i = 0;i<list.size();i++) {
			list.get(i);
		}
		System.out.println("for±éÀú  "+(System.currentTimeMillis()-time1)+"ms");
		
		long time2 = System.currentTimeMillis();
		for(E e: list) {
			
		}
		System.out.println("foreach±éÀú  "+(System.currentTimeMillis()-time2)+"ms");
	}
	
	static void Evaluator(String s) {
		Stack<String> stack = new Stack<String>();
		int addnum = 0;
		for(char c:s.toCharArray()) {
			if(c=='+') 
				addnum++;
			else if(c=='-') 
				System.out.print(stack.pop());
			else {
				if(addnum>0) {
					stack.add(String.valueOf(c));
				}
					
			}
		}
	}
	
	public static void main(String[] args) {
//		List<Integer> list1 = new ArrayList<Integer>();
//		List<Integer> list2 = new LinkedList<Integer>();
//		for(int i = 0;i<10000;i++) {
//			list1.add(i);
//			list2.add(i);
//		}
//		System.out.println("ArrayList test:");
//		loopList(list1);
//		System.out.println("\nLinkedList test:");
//		loopList(list2);
		
//		Stack<String> stack = new Stack<String>();
//		for(String s:"hehe mmm aaa".split(" ")) {
//			stack.add(s);
//		}
//		for(String s:stack)
//			System.out.print(s+" ");
//		stack.add(1, "gaoxiao");
//		System.out.println();
//		for(String s:stack)
//			System.out.print(s+" ");
//		String s = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---";
//		Evaluator(s);
//		Set<String> set = new HashSet<String>();
//		Collections.addAll(set, "A B C D E F G H I J K L M".split(" "));
		
		Set<String> words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		words.addAll(new TextFile("E:\\Java\\ThinkInJava\\src\\holding\\E04_MovieNameGenerator.java","\\W+"));
		System.out.println(words);
	}
	
}
