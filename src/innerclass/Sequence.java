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
		
		public Sequence getSequence(){
			return Sequence.this;
		}
		
	}
	
	private class ReverseSelector implements Selector{
		int i = items.length - 1;
		@Override
		public boolean end() {
			return i < 0;
		}

		@Override
		public Object current() {
			return items[i];
		}

		@Override
		public void next() {
			if(i >= 0) i--;
		}
		
	}
	
	public Selector reverseSelector(){
		return new ReverseSelector();
	}
	
	public Selector selector(){
		return new SequenceSelector();
	}
	
	public void print(){
		System.out.println("this.");
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
		Selector reverseselector = sequence.reverseSelector();
		while(!reverseselector.end()){
			System.out.println(reverseselector.current().toString());
			reverseselector.next();
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
