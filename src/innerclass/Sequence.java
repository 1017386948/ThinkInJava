package innerclass;

interface Selector{
	boolean end();
	Object current();
	void next();
}

public class Sequence {
	private int next = 0;
	private Object[] items;
	public Sequence(int size){
		items = new Object[size];
	}
	public void add(Object x){
		if(next<items.length)
			items[next++] = x;
	}
	private class SequenceSelector implements Selector{
		private int i = 0;
		@Override
		public boolean end() {
			return i==items.length;
		}

		@Override
		public Object current() {
			return items[i];
		}

		@Override
		public void next() {
			if(i<items.length)
				i++;
		}
		
	}
	public Selector selector(){
		return new SequenceSelector();
	}
	
	public static void main(String[] args){
		Sequence sequence = new Sequence(4);
		for(int i = 0;i<4;i++){
			sequence.add(new StringSequence("No: "+i));
		}
		Selector selector = sequence.selector();
		while(!selector.end()){
			System.out.println(selector.current().toString());
			selector.next();
		}
	}
}

class StringSequence{
	private String s;
	public String toString(){
		return s;
	}
	public StringSequence(){}
	public StringSequence(String s){
		this.s = s;
	}
}
