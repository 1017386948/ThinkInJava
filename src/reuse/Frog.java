package reuse;

class Vmphibian{
	void swim(){
		System.out.println("Swimming.");
	}
	void walk(){
		System.out.println("Walking.");
	}
	static void life(Vmphibian v){
		v.swim();
		v.walk();
	}
}

public class Frog extends Vmphibian{
	void swim(){
		System.out.println("frog Swimming.");
	}
	void walk(){
		System.out.println("frog Walking.");
	}
	public static void main(String[] args){
		Vmphibian f = new Frog();
		life(f);	//Upcasting
	}
}
