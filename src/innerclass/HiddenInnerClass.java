package innerclass;

interface contents{
	public void value();
}

class Parcel {
	public contents internal(){
		{
			class mContents implements contents{
			@Override
			public void value() {
				System.out.println("mContents.value");	
			}
		}
		
		return  new mContents();
		}
		
	}
	
	public contents internal2(int i){
		return new contents(){
			@Override
			public void value() {	
			
				System.out.println(i);
			}
			
		};
	}
	
	
	private class Inner implements contents{

		@Override
		public void value() {
			System.out.println("Inner.value");
		
		}
	}
	public Inner get1(){
		return new Inner();
	}
	public contents get2(){
		return new Inner();
	}

}

public class HiddenInnerClass{
	public static void main(String[] args){
		Parcel p = new Parcel();
		contents c = p.get2();
		c = p.get1();
		int i = 5;
		p.internal2(i).value();
	}
}
