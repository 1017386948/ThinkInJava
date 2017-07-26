package holding;

import java.util.ArrayList;

public class Gerbil {
	private int gerbilNumber;
	Gerbil(int gerbilNumber){
		this.gerbilNumber =gerbilNumber;
	}
	void hop(){
		System.out.println(this + " is hopping");
	}
	@Override 
	public String toString(){
		return "gerbil " + gerbilNumber;
	}
	public static void main(String[] args){
		ArrayList<Gerbil> Gerbils = new ArrayList<Gerbil>();
		for(int i=0;i<5;i++){
			Gerbils.add(new Gerbil(i));
		}
		for(int i=0;i<Gerbils.size();i++){
			Gerbils.get(i).hop();
		}
	}
}
