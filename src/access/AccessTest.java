package access;

import initialization.ArrayNew;

class Cookies{
	Cookies(){
		System.out.println("Constructor of Cookies.");
	}
	public void chomp1(){
		System.out.println("public chomp.");
	}
	
	protected void chomp2(){
		System.out.println("protected chomp.");
	}
	
	void chomp3(){
		System.out.println("default chomp.");
	}
	
	private void chomp4(){
		System.out.println("private chomp.");
	}
	
}

public class AccessTest {
	public static void main(String[] args){
		Cookies c = new Cookies();
		c.chomp1();
		c.chomp2();
		c.chomp3();
//		c.chomp4();

	}
}
